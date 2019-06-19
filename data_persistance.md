# Data Persistance

## Bespoke

```
BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

String line;

while ((line = reader.readLine()) != null) {
  String[] sections = line.split(" ");

  animals.add(new Animal(sections[0], sections[1], Integer.parseInt(sections[2])));
}
```

## JSON

```
JSONParser parser = new JSONParser();

FileReader reader = new FileReader("animals.json");

JSONObject data = (JSONObject) parser.parse(reader);

JSONArray anims = (JSONArray) data.get("Animals");

Iterator it = anims.iterator();

while (it.hasNext()) {
  JSONObject obj = (JSONObject) it.next();

  String name = (String) obj.get("name");
  String breed = (String) obj.get("breed");
  long age= (long) obj.get("age");

  animals.add(new Animal(name, breed, (int) age));
}
```

## XML

```
File f = new File(filename);

DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder db = factory.newDocumentBuilder();

doc = db.parse(f);
```
