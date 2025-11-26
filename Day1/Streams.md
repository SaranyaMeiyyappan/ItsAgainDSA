📝 Java 8 Streams Cheat Sheet — Interview Edition
1️⃣ Stream Structure
source → intermediate operations → terminal operation


Source: Collection, array, Stream.of(), Optional.stream()

Intermediate (lazy, chainable): filter, map, flatMap, sorted, distinct, peek, limit, skip

Terminal (eager, triggers execution): collect, forEach, count, reduce, anyMatch, allMatch, findFirst, min, max

2️⃣ Rules to Remember

Every stream pipeline must end with a terminal operation → otherwise nothing executes.

Intermediate operations are lazy → chained transformations are not evaluated until a terminal op is called.

Use Optional / null checks to avoid NPEs in streams.

Streams are declarative → prefer for readable, functional-style transformations; use loops for imperative logic, performance, or index-based access.

3️⃣ Commonly Used Intermediate Operations
Operation	Example	Notes
filter	.filter(s -> s.length()>3)	Keep only elements matching condition
map	.map(String::toUpperCase)	Transform elements
flatMap	.flatMap(list -> list.stream())	Flatten nested structures
sorted	.sorted() / .sorted(String::compareTo)	Natural order or custom comparator
distinct	.distinct()	Remove duplicates
peek	.peek(System.out::println)	Debug / inspect
limit	.limit(5)	Take first n elements
skip	.skip(2)	Skip first n elements
4️⃣ Commonly Used Terminal Operations
Operation	Example	Returns
collect	.collect(Collectors.toList())	List/Set/Map
forEach	.forEach(System.out::println)	void
count	.filter(x -> x>0).count()	long
reduce	.reduce(0, Integer::sum)	Optional<T> or T
anyMatch	.anyMatch(s -> s.startsWith("S"))	boolean
allMatch	.allMatch(x -> x>0)	boolean
findFirst	.findFirst()	Optional<T>
min/max	.min(Comparator.naturalOrder())	Optional<T>
5️⃣ Quick Examples
Filter + Map + Collect
List<String> result = list.stream()
    .filter(s -> s.length() > 3)
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.toList());

Count
long cnt = list.stream()
    .filter(s -> s.startsWith("S"))
    .count();

Reduce / Sum
int sum = list.stream()
    .mapToInt(String::length)
    .sum();

Grouping
Map<Integer, List<String>> grouped = list.stream()
    .collect(Collectors.groupingBy(String::length));

6️⃣ Interview Tips

Explain why you chose streams vs loops

Always handle nulls using Optional or early return

Mention lazy evaluation of intermediate ops

Show readability and functional style

Avoid streams for nested loops or heavy imperative logic

💡 Rule of Thumb:

Memorize the common intermediate + terminal ops. Understand structure, rules, and patterns. Everything else you can look up quickly.
