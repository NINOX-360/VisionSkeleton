package ninox360;

import boofcv.alg.filter.derivative.DerivativeType;
import boofcv.alg.filter.derivative.GImageDerivativeOps;
import boofcv.gui.BoofSwingUtil;
import boofcv.gui.ListDisplayPanel;
import boofcv.gui.image.ShowImages;
import boofcv.gui.image.VisualizeImageData;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.io.image.UtilImageIO;
import boofcv.struct.border.BorderType;
import boofcv.struct.image.GrayF32;
import boofcv.struct.image.GrayU8;
import boofcv.struct.image.ImageType;

import javax.swing.*;
import java.io.File;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Opens a dialog and lets you select an image. Then performs edge detection on the image and displays the results.
 *
 * @author Peter Abeles
 */
public class HelloWorld {
    public static void main(String[] args) {
        File f = BoofSwingUtil.openFilePreview("helloworld", BoofSwingUtil.FileTypes.IMAGES);
        if (f == null) {
            System.out.println("User did not select an image");
            return;
        }

        // Load selected image as a 32-bit floating point image
        GrayF32 gray = requireNonNull(UtilImageIO.loadImage(f, true, ImageType.SB_F32));

        // Storage for derivative
        GrayF32 derivX = gray.createSameShape();
        GrayF32 derivY = gray.createSameShape();

        // Find the gradient
        GImageDerivativeOps.gradient(DerivativeType.SOBEL, gray, derivX, derivY, BorderType.EXTENDED);

        // Display results
        var gui = new ListDisplayPanel();
        gui.addImage(ConvertBufferedImage.convertTo(gray, null), "Input Grey");
        gui.addImage(VisualizeImageData.colorizeSign(derivX, null, -1), "Sobel X");
        gui.addImage(VisualizeImageData.colorizeSign(derivY, null, -1), "Sobel Y");

        ShowImages.showWindow(gui, "Image Gradient", true);
    }
}
