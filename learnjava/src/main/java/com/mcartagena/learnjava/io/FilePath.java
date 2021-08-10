package com.mcartagena.learnjava.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePath {

    private static final String FILE_SEPARATOR = File.separator;
    private static final String FILE_SEPARATOR2
            = FileSystems.getDefault().getSeparator();

    public static void main(String[] args) throws IOException {

//        joiningFilePaths();

        // Path for directory
//        getPathForDirectory();

        // Path for file
//        getPathForFile();

        compareFilePaths();

    }

    private static void compareFilePaths() {
        Path path1 = Paths.get("/learning/packt/JavaModernChallenge.pdf");
        Path path2 = Paths.get("/LEARNING/PACKT/JavaModernChallenge.pdf");
        Path path3 = Paths.get("D:/learning/packt/JavaModernChallenge.pdf");

        boolean path1EqualsPath2 = path1.equals(path2); // true
        boolean path2EqualsPath3 = path2.equals(path3); // false

        System.out.println("Path1 : " + path1);
        System.out.println("Path2 : " + path2);
        System.out.println("path 1 Equlas Path2: " + path1EqualsPath2);

        System.out.println("Path3 : " + path3);
        System.out.println("path 2 Equlas Path3: " + path2EqualsPath3);
    }

    private static void joiningFilePaths() {
        // File separator from java.io.File

        System.out.println("File.separator: " + FILE_SEPARATOR);
        System.out.println("File.separator2: " + FILE_SEPARATOR2);

        // path relative to the file store root
        Path path = Paths.get(FILE_SEPARATOR + "learning",
                "packt", "JavaModernChallenge.pdf").toAbsolutePath();
        Path path1 = Path.of(FILE_SEPARATOR + "learning",
                "packt", "JavaModernChallenge.pdf").toAbsolutePath();

        System.out.println("Paths: " + path + " " + path1);

        // get the root directory
        for (File file : File.listRoots()) {
            System.out.println("File.listRoots: " + file);
        }

        FileSystems.getDefault().getRootDirectories().forEach(p -> System.out.println("The list of root directories: " + p.toString()));

        Path path2 = Paths.get(File.listRoots()[0] + "learning",
                "packt", "JavaModernChallenge.pdf");
        Path path3 = Path.of(File.listRoots()[0] + "learning",
                "packt", "JavaModernChallenge.pdf");

        System.out.println("Paths: " + path2 + " " + path3);

        Path base = Paths.get("/learning/packt/JavaModernChallenge.pdf");

        System.out.println("Base path: " + base);

        Path pathSibling = base.resolveSibling("MasteringJSF22.pdf");

        System.out.println("Path resolve sibling: " + pathSibling);

        Path pathComplex = base.getParent().resolveSibling("publisher")
                .resolve("MyBook.pdf");

        System.out.println("Path resolve sibling: " + pathComplex);
    }

    private static void getPathForFile() {
        Path path = Paths.get("/learning/packt/JavaModernChallenge.pdf");
        Path path1 = Paths.get("/learning", "packt/JavaModernChallenge.pdf");

        System.out.println("Paths: " + path + " " + path1);

        Path path2 = Path.of("/learning/packt/JavaModernChallenge.pdf");
        Path path3 = Path.of("/learning", "packt/JavaModernChallenge.pdf");

        System.out.println("Paths: " + path2 + " " + path3);

        Path path4 = FileSystems.getDefault()
                .getPath("/learning/packt", "JavaModernChallenge.pdf");
        Path path5 = FileSystems.getDefault()
                .getPath("/learning/packt/JavaModernChallenge.pdf");

        System.out.println("Paths: " + path4 + " " + path5);

        Path path6 = Paths.get(
                URI.create("file:///learning/packt/JavaModernChallenge.pdf"));
        Path path7 = Path.of(
                URI.create("file:///learning/packt/JavaModernChallenge.pdf"));

        System.out.println("Paths: " + path6 + " " + path7);

        // Creating a path relative to the current folder
        Path path8 = Paths.get("learning/packt/JavaModernChallenge.pdf");
        Path path9 = Paths.get("learning", "packt/JavaModernChallenge.pdf");

        System.out.println("Paths: " + path8 + " " + path9);

        Path path10 = Path.of("learning/packt/JavaModernChallenge.pdf");
        Path path11 = Path.of("learning", "packt/JavaModernChallenge.pdf");

        System.out.println("Paths: " + path10 + " " + path11);

        Path path12 = FileSystems.getDefault()
                .getPath("learning/packt", "JavaModernChallenge.pdf");
        Path path13 = FileSystems.getDefault()
                .getPath("learning/packt/JavaModernChallenge.pdf");

        System.out.println("Paths: " + path12 + " " + path13);

        Path basePath = Paths.get("/learning/packt");
        String[] books = {
                "Book1.pdf", "Book2.pdf", "Book3.pdf"
        };

        for (String book: books) {
            Path nextBook = basePath.resolve(book);
            System.out.println(nextBook);
        }
    }

    private static void getPathForDirectory() throws IOException {
        Path currentDirectory = Path.of("./src/../test");

        System.out.println("Current Path : " + currentDirectory);

        Path parentPath = currentDirectory.getParent();

        System.out.println("Parent Path: " + parentPath);

        Path normalizePath = currentDirectory.normalize();

        System.out.println("Normalize Path: " + normalizePath);

        Path relativePath = Path.of("./target");

        Path relativizePath = currentDirectory.relativize(relativePath);

        System.out.println("Relativize Path: " + relativizePath);

        Path resolvePath = currentDirectory.resolve("./deploy");

        System.out.println("Resolve Path: " + resolvePath);

        Path resolvePath2 = currentDirectory.resolve(relativePath);

        System.out.println("Resolve Path 2: " + resolvePath2);

        Path resolveSibling = currentDirectory.resolveSibling("./deploy");

        System.out.println("Resolve Sibling Path: " + resolveSibling);

        Path resolveSibling2 = currentDirectory.resolveSibling(relativePath);

        System.out.println("Resolve Sibling Path 2: " + resolveSibling2);

        Path subPath = resolveSibling.subpath(0, 3);

        System.out.println("SubPath: " + subPath);

        Path absolutePath = resolveSibling.toAbsolutePath();

        System.out.println("Absolute Path: " + absolutePath);

        Path realPath = resolveSibling2.toRealPath(LinkOption.NOFOLLOW_LINKS);

        System.out.println("Real Path: " + realPath);

        Path rootPath = realPath.getRoot();

        System.out.println("Root Path: " + rootPath);
    }
}
