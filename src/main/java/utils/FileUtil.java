package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;



public final class FileUtil {
    private static final ClassLoader LOADER = FileUtil.class.getClassLoader();

    private FileUtil() {
    }

    /**
     * Reads a (text) file entirely into a string. The charset of the file must
     * be UTF-8.
     *
     * @param file The complete name of the file.
     * @return
     */
    public static String readFile(String file) {
        try (InputStream inputStream = LOADER.getResourceAsStream(file)) {
            assert inputStream != null;
            String s = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
            return s;
        } catch (IOException e) {
        }
        return file;
    }
}

