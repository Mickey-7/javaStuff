
var list2 = new java.util.ArrayList();
list2.add("ddd2");
list2.add("aaa2");
list2.add("bbb1");
list2.add("aaa1");
list2.add("bbb3");
list2.add("ccc");
list2.add("bbb2");
list2.add("ddd1");

list2
    .stream()
    .filter(function (elem1) {
        return elem1.startsWith("aaa")
    })
    .sorted()
    .forEach(function (elem1) {
        print(elem1)
    });

//aaa1
//aaa2