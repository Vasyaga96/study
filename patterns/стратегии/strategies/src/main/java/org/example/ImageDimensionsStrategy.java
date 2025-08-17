package org.example;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageDimensionsStrategy implements FileDimensionsStrategy {
    @Override
    public boolean supports(File file) {
        return isJpeg(file) || isPng(file);
    }

    @Override
    public void printDimensions(File file) {
        String suffix = isPng(file) ? "png" : "jpg";

        Iterator<ImageReader> readers = ImageIO.getImageReadersBySuffix(suffix);

        if (!readers.hasNext()) {
            System.out.printf("%s: unsupported image format\n", file.getName());
            return;
        }

        ImageReader reader = readers.next();

        try (ImageInputStream stream = new FileImageInputStream(file)) {
            reader.setInput(stream);

            int width = reader.getWidth(reader.getMinIndex());
            int height = reader.getHeight(reader.getMinIndex());

            System.out.printf("%s: %d x %d pixels\n", file.getName(), width, height);
        } catch (IOException e) {
            System.out.printf("%s: error reading file (%s)\n", file.getName(), e.getMessage());
        } finally {
            reader.dispose();
        }
    }

    private boolean isJpeg(File file) {
        String filename = file.getName().toLowerCase();
        return filename.endsWith(".jpg") || filename.endsWith(".jpeg");
    }

    private boolean isPng(File file) {
        String filename = file.getName().toLowerCase();
        return filename.endsWith(".png");
    }
}
