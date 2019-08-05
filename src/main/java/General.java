import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class General {
    public static void main(String... args){

        int n = 50;
        List<Integer> bundles = new ArrayList<>();
        bundles.add(20);
        bundles.add(24);

        List<Integer> costs = new ArrayList<>();
        costs.add(24);
        costs.add(19);

        List<Integer> numberOfBundles = costs.stream().map(a -> n / a).collect(Collectors.toList());

        List<Integer> totalNoteBooks = new ArrayList<>();
        for(int i = 0; i < bundles.size(); i++){
            totalNoteBooks.add(bundles.get(i) * numberOfBundles.get(i));
        }

        Integer maxNoteBooks = Collections.max(totalNoteBooks);
        System.out.println(maxNoteBooks);
        Integer maxIndex = totalNoteBooks.indexOf(maxNoteBooks);

        numberOfBundles.stream().forEach(System.out::println);

        List<Integer> modulus = costs.stream().map(a -> a % n).collect(Collectors.toList());

        Integer remainingMoney = modulus.get(maxIndex);

        System.out.println(remainingMoney);













       // Integer pId = 0;

//        Map<Per, String> map = new HashMap<>();
//        //check the limit of the hashmap
//        while(true){
//            Per p = new Per();
//            p.setId(pId);
//            pId++;
//            p.setName("Test");
//            map.put(p,"Test");
//        }



    }
}
class Per{
    private Integer id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Per)) return false;
        Per per = (Per) o;
        return getId().equals(per.getId()) &&
                getName().equals(per.getName());
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
