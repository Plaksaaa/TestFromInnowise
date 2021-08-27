package com.innowise.file.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class FileWriterUtil {

    private FileWriterUtil() {
    }

    public static void writeToFileEnd(String path, String message) {

        File file = new File(path);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {

            bufferedWriter.write("\n");

            bufferedWriter.write(message);

            bufferedWriter.newLine();

            bufferedWriter.flush();

        } catch (IOException e) {

            throw new RuntimeException("Ups, failed to write into file: " + path, e);

        }

    }
}
