import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testSnippet1() throws IOException{
        ArrayList<String> compareString = new ArrayList<String>();
        compareString.add("'google.com");
        compareString.add("google.com");
        compareString.add("ucsd.edu");
        Path fileName = Path.of("Snippet-1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(compareString, links);
    }

    @Test
    public void testSnippet2() throws IOException{
        ArrayList<String> compareString = new ArrayList<String>();
        compareString.add("a.com");
        compareString.add("a.com(())");
        compareString.add("example.com");
        Path fileName = Path.of("Snippet-2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(compareString, links);
    }

    @Test
    public void testSnippet3() throws IOException{
        ArrayList<String> compareString = new ArrayList<String>();
        compareString.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        Path fileName = Path.of("Snippet-3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(compareString, links);
    }

}