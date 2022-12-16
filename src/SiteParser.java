//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//
//import java.io.IOException;
//import java.util.List;
//
//public class SiteParser {
//}
//import org.jsoup.Jsoup;
//        import org.jsoup.nodes.Document;
//
//        import java.io.IOException;
//        import java.nio.file.Files;
//        import java.nio.file.Path;
//        import java.nio.file.Paths;
//        import java.nio.file.StandardOpenOption;
//        import java.util.List;
//
//
//public class Main {
//    public static void main(String[] args) throws IOException, InterruptedException {
//        String url = "https://lenta.ru/";
//
//        int threadCount = 5;//количество поток
//
//        StringBuilder[] linkstree = new StringBuilder[threadCount];
//        for (int i = 0; i < linkstree.length; i++) {
//            linkstree[i] = new StringBuilder();
//        }
//        Thread[] myThreads = new Thread[threadCount];
//        var links = ParseSite.getLinks(url);
//        int slice = links.size() % threadCount;
//        for (int i = 0; i < threadCount; ++i) {
//            myThreads[i] = new Thread(new MyRunnable(linkstree[i], links.subList(i * slice, (i == threadCount - 1 ? (links.size() - 1) : (slice * (i + 1)))), 1));
//            myThreads[i].start();
//        }
//        for (int j = 0; j < threadCount; j++) {
//            myThreads[j].join();
//        }
//        java.nio.file.Path path = java.nio.file.Paths.get("links_tree.txt");//имя фйайл с ответом
//        java.nio.file.Files.write(path, (url + "\n").getBytes());
//        for (var str : linkstree) {
//            java.nio.file.Files.write(path, str.toString().getBytes(), java.nio.file.StandardOpenOption.APPEND);
//        }
//    }
//}
//
//
//class ParseSite {
//
//    public static List<String> getLinks(String url) throws IOException {
//        Document doc = Jsoup.connect(url).get();
//        return doc.select("a[href]")
//                .stream()
//                .map(x -> x.attr("abs:href"))
//                //.filter(x -> x.contains(url) && !(x.equals(url)))
//                .filter(x -> x.matches(String.format("^%s[^#.]+$", url)))
//                .toList();
//    }
//
//    public static void crete_linkstree(String url, int tabs, StringBuilder str) throws IOException, InterruptedException {
//        Thread.sleep(155);
//        var links = getLinks(url);
//        if (links.size() > 0) {
//            str.append(String.format("%s%s\n", getTabs(tabs), links.get(0)));
//            links.forEach(x -> {
//                try {
//                    crete_linkstree(x, tabs + 1, str);
//                } catch (Exception e) {
//                    System.out.println(e);
//
//                }
//            });
//        }
//    }
//
//    private static String getTabs(int tabs) {
//        return "\t".repeat(Math.max(0, tabs));
//    }
//}
//
//class MyRunnable extends Thread {
//    List<String> links;
//    int tabs;
//
//    StringBuilder str;
//
//    public MyRunnable(StringBuilder str, List<String> links, int tabs) {
//        this.str = str;
//        this.links = links;
//        this.tabs = tabs;
//    }
//
//    @Override
//    public void run() {
//        links.forEach(link -> {
//            try {
//                //System.out.println(link);
//                str.append(String.format("%s%s\n", getTabs(tabs), links.get(0)));
//                ParseSite.crete_linkstree(link, tabs, str);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
//    }
//
//    private static String getTabs(int tabs) {
//        return "\t".repeat(Math.max(0, tabs));
//    }
//}