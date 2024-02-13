package designPatterns;

import java.util.ArrayList;
import java.util.List;

interface IFileSystem {
    void ls();
}

class Directory implements IFileSystem {
    String directoryName;
    List<IFileSystem> files;

    Directory(String directoryName) {
        this.directoryName = directoryName;
        files = new ArrayList<>();
    }
    public void ls() {
        System.out.println("In " + directoryName);
        for (IFileSystem fs : files) {
            fs.ls();
        }
    }

    public void addFs(IFileSystem fs) {
        this.files.add(fs);
    }
}

class File implements IFileSystem {
    String filename;
    File(String filename){
        this.filename = filename;
    }
    public void ls() {
        System.out.println("In " + filename);
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        Directory comedyMoviesDirectory = new Directory("Comedy");
        Directory actionComedyMoviesDirectory = new Directory("ActionComedy");
        Directory romanticComedyMoviesDirectory = new Directory("RomanticComedy");

        comedyMoviesDirectory.addFs(actionComedyMoviesDirectory);
        comedyMoviesDirectory.addFs(romanticComedyMoviesDirectory);

        comedyMoviesDirectory.ls();
    }
}
