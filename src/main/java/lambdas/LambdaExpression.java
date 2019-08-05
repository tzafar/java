package lambdas;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Created by ZafarT on 30/05/2018.
 */
public class LambdaExpression {
    public static void main(String... args) throws Exception {

       /* List<String> strings = new ArrayList<>();
        strings.add("asdf");
        List<String> bb  = strings.stream().map(v -> v.toUpperCase()).collect(Collectors.toList());*/

        // byte[] rss = Base64.getDecoder().decode("aPrxKT51WsFU0XnpTsPt6Opp_F9Hq3u8WZy7Xa0D_REo3R.swDu8vORs.mCsx7i3mufwCFFOVQ==");
        //System.out.println("Decode value: " + rss.toString());



        String myName = "'java interview'";
        char[] ca = myName.toCharArray();
        String result = "";
        for(int in = ca.length -1 ; in > -1 ; in--){
            result += ca[in];
        }
        System.out.println("Output: " + result);

        Integer[] arr = new Integer[]{1,2,3,3,5,6,7};
        int re  = Arrays.stream(arr).max(Comparator.comparing(a -> (Integer)a )).get();
        Integer convertToIntegerObject = Stream.of(arr).mapToInt(v -> v).max().getAsInt();

        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(1.1);
        Double d = doubles.stream().mapToDouble(v -> v).average().orElse(0.0);
        System.out.println(d);



        System.out.println(re);

        afterLambda();
        long a = Stream.of("A", "Touseef", "sumaira", "saira", "Ahtasham")
                .filter(s -> s.startsWith("s"))
                .map(String::toUpperCase)
                .count();

        System.out.print(a);

        // Date time api

        LocalDate localDate = LocalDate.now();
        print("localDate.getDayOfMonth() = ", localDate.getDayOfMonth());
        print("localDate.toString() = ", localDate.toString());
        print("localDate.atStartOfDay().toString() = ", localDate.atStartOfDay().toString());
        print("localDate.format(DateTimeFormatter.BASIC_ISO_DATE) = ", localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
        print("localDate.format(DateTimeFormatter.ISO_DATE) = ", localDate.format(DateTimeFormatter.ISO_DATE));
        //print("localDate.format(DateTimeFormatter.ISO_DATE_TIME) = ", localDate.format(DateTimeFormatter.ISO_DATE_TIME));
        //print("localDate.format(DateTimeFormatter.ISO_INSTANT) = ", localDate.format(DateTimeFormatter.ISO_INSTANT));
        print("localDate.format(DateTimeFormatter.ISO_LOCAL_DATE) = ", localDate.format(DateTimeFormatter.ofPattern("dd MMMM YYYY")));


        LocalTime localTime = LocalTime.now();
        print("localTime.getDayOfMonth() = ", localTime.getHour());
        print("localTime.toString() = ", localTime.toString());
        print("localTime.atStartOfDay().getSecond() = ", localTime.getSecond());
        print("localTime.format(TimeTimeFormatter.ISO_LOCAL_Time) = ", localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        print("localTime.format(TimeTimeFormatter.ISO_LOCAL_Time) = ", localTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));


        HashMap<String, Object> exapmleHashMap = new HashMap<>();
        exapmleHashMap.put("a", "b");
        Object a1 = exapmleHashMap.get("a");
        Object b = exapmleHashMap.get("b");
        print("a1 = ", a1);
        print("b = ", b);


        runLambaExamples();
  

    }

    private static void runLambaExamples(){
        System.out.println("Example 1 ------ forEach()");
        IntStream.range(0, 5).forEach(System.out::println);

        System.out.println("Example 2 ------ skip()");
        IntStream.range(0, 5).skip(1).forEach(System.out::println);

        System.out.println("Example 3 ------ sum()");
        long sum = IntStream.range(0, 5).sum();
        System.out.println(sum);

        System.out.println("Example 4 ------ Stream.of / sorted() / findFirst() / ifPresent()");
        Stream.of("Mirza", "toseef", "zafar").sorted().findFirst().ifPresent(System.out::println);

        System.out.println("Example 5 ------ Arrays to Stream / filter() / sort()");
        String[] names = {"Zafar", "majeeda", "sohail", "sumaira", "toseef", "ahtasham"};
        Arrays.stream(names)
                .filter(o -> o.startsWith("s"))
                .sorted()
                .forEach(System.out::println);


        System.out.println("Example 6 ------ Arrays to Stream / average() / map()");
        Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})
                .map(o -> o * o)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Example 7 ------ Lists to Stream / filter() / map()");
        List<String> familyNames = Arrays.asList("Zafar", "majeeda", "sohail", "sumaira", "toseef", "ahtasham");
        familyNames.stream()
                .map(String::toUpperCase)
                .filter(name -> name.startsWith("S"))
                .forEach(System.out::println);

        System.out.println("Example 8 ------ File to Stream / filter() / sorted()");
        try (Stream<String> bands = Files.lines(Paths.get("src/bands.txt"))) {
            bands
                    .sorted()
                    .filter(x -> x.length() > 13)
                    .forEach(System.out::println);
            bands.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Example 9 ------ File to Stream / filter() / collect()");
        try (Stream<String> bands = Files.lines(Paths.get("src/bands.txt"))) {
            List<String> bands2 = bands
                    .filter(x -> x.contains("line"))
                    .collect(Collectors.toList());
            bands.close();
            bands2.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Example 10 ------ File to Stream / map() / filter() / count()");
        try (Stream<String> csv = Files.lines(Paths.get("src/csv.txt"))) {
            int count = (int) csv
                    .map(x -> x.split(","))
                    .filter(x -> x.length > 1)
                    .count();
            csv.close();
            System.out.println("The good rows are: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Example 11 ------ File to Stream / map() / filter() filter() / count()");
        try (Stream<String> csv = Files.lines(Paths.get("src/csv.txt"))) {
            csv
                    .map(x -> x.split(","))
                    .filter(x -> x.length > 1)
                    .filter(x -> Integer.parseInt(x[1]) > 1)
                    .forEach(x->System.out.println(x[0] + "  " + x[1]));
            csv.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Example 12 ------ File to Stream / map() / filter() / filter() / collect() to Map");
        try (Stream<String> csv = Files.lines(Paths.get("src/csv.txt"))) {
            Map<String,Integer> map = csv
                    .map(x -> x.split(","))
                    .filter(x -> x.length > 1)
                    .filter(x -> Integer.parseInt(x[1]) > 1)
                    .collect(Collectors.toMap(
                            x -> x[0],
                            x -> Integer.parseInt(x[1])));
            csv.close();
            for(String key : map.keySet()){
                System.out.println("Key: "  + key  + "\tValue:" + map.get(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Example 13 ------ Double to Stream / reduce()");
        double total = Stream.of(1.1,2.2,3.3).reduce(0.0, (Double x, Double y) -> x+y);
        System.out.println("Total = " + total);

        System.out.println("Example 14 ------ Integer to Stream / SummaryStatistics()");
        IntSummaryStatistics summary = IntStream.of(1,2,3,4,5,6).summaryStatistics();
        System.out.println("Summary = " + summary);


        System.out.println("Example 15 ------ Double to Stream / summaryStatistics()");
        DoubleSummaryStatistics doubleSummaryStatistics = DoubleStream.of(1.1,2.2,3.3).summaryStatistics();
        System.out.println("doubleSummary = " + doubleSummaryStatistics);
    }

    private static void print(String message, Object object) {
        System.out.println(message + object);
    }

    public static void beforeLambda() {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
    }

    public static void afterLambda() {
        File[] nonHiddenFiles = new File("/Users/toszafar").listFiles(File::isHidden);
        for (File hiddenFile : nonHiddenFiles) {
            System.out.println(hiddenFile.toString());
        }
    }
}
