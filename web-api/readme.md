# Tests

1. testFromString teste si la fonction fromString de la classe [GHPoint](src/main/java/com/graphhopper/util/shapes/GHPoint.java) parse correctement le string en input en créant correctement l'objet GHPoint, elle vérifie si "Lat" et "Lon" de l'objet GHPoint sont bien initialisés. Le string testé est : "12.34,34.98", on s'attend à ce que GHPoint.lat = 12.34 et GHPoint.lon = 34.98. [Lien vers le test](src/test/java/com/graphhopper/util/shapes/GHPointTest.java)

2. testFromStringLonLat teste si la fonction fromStringLonLat de la classe [GHPoint](src/main/java/com/graphhopper/util/shapes/GHPoint.java) parse correctement le string en input en créant correctement l'object GHPoint, elle vérifie si "Lat" et "Lon" de l'objet GHPoint sont bien initialisés. Le string testé est : "12.34, 34.98", on s'attend à ce que GHPoint.lon = 12.34 et GHPoint.lat = 34.98 [Lien vers le test](src/test/java/com/graphhopper/util/shapes/GHPointTest.java)

3. testIllegalFromString teste si la fonction fromString de la classe [GHPoint](src/main/java/com/graphhopper/util/shapes/GHPoint.java) lance correctement l'Exception IllegalArgumentException si le string en input ne contient que un seul chiffre au lieu de deux, le test vérifie que l'exception est lancée et il test si le message de l'exception est le bon. Le string testé est : "12.34", on s'attend à ce que la fonction lance l'exception IllegalArgumentException avec le message : "Cannot parse point '12.34'" [Lien vers le test](src/test/java/com/graphhopper/util/shapes/GHPointTest.java)

4. testNumberExceptionFromString teste si la fonction fromString de classe [GHPoint](src/main/java/com/graphhopper/util/shapes/GHPoint.java) lance correctement l'exception IllegalArgumentException quand le string en entrée ne contient pas de nombres mais d'autres charactères. Le test vérifie que l'exception est bien lancée et il vérifie que le message renvoyé est le bon message. Le string testé est : "test, wrong", on s'attend à ce que la fonction lance l'exception IllegalArgumentException avec le message :  "Cannot parse point 'test, wrong'". [Lien vers le test](src/test/java/com/graphhopper/util/shapes/GHPointTest.java)

5. testFromJson teste si la fonction fromJson de la classe [GHPoint](src/main/java/com/graphhopper/util/shapes/GHPoint.java) crée correctement l'objet GHPoint lorsque qu'on lui passe un tableau de "double", la fonction vérifie que l'objet créer avec la fonction fromJson prend bien les deux premiers éléments du tableau en entrée et est le même que l'objet créer à la main.
Le tableau testé est [2.4, 3.1, 4.8, 8.3, 5.3], on s'attend à ce que le GHPoint créer par la fonction soit un point équivalent au point créer avec new GHPoint(3.1, 2.4) car il s'agit des deux premiers éléments du tableau. [Lien vers le test](src/test/java/com/graphhopper/util/shapes/GHPointTest.java)

6. testParseListEmpty teste si la fonction parseList de la classe [Helper](src/main/java/com/graphhopper/util/Helper.java) crée bien une liste vide lorsqu'on lui passe un string vide en entrée. Le string testé est : "", on s'attend à ce que la fonction crée une liste vide : []. [Lien vers le test](src/test/java/com/graphhopper/util/HelperTest.java)

7. testParseList teste si la fonction parseList de la classe [Helper](src/main/java/com/graphhopper/util/Helper.java) crée bien une liste contenant les bons éléments dans une string sous forme de tableau "[1,2,3]". Le teste vérifie que la fonction transforme bien la string en liste de string ["1","2","3"] [Lien vers le test](src/test/java/com/graphhopper/util/HelperTest.java)

8. testAddPointNullException teste si la fonction addPoint de la classe [GHRequest](src/main/java/com/graphhopper/GHRequest.java) lance correctement une exception lorsqu'on essaye d'ajouter un point "null". Le teste vérifie que l'exception lancée est IllegalArgumentException et que le message de l'exception est : "point cannot be null".[Lien vers le test](src/test/java/com/graphhopper/util/GHRequestTest.java)

9. testAddPoint teste si la fonction addPoint de la classe [GHRequest](src/main/java/com/graphhopper/GHRequest.java) ajoute correctement les deux points GHPoint qu'on a ajouté, le test vérifie que les points ajoutés dans l'instance de GHRequest a les mêmes points GHPoint que ceux qu'on a ajouté.
[Lien vers le test](src/test/java/com/graphhopper/util/GHRequestTest.java)

10. testAddDebugInfo teste si la fonction addDebugInfo de la classe [GHResponse](src/main/java/com/graphhopper/GHResponse.java) lance correctement une exception lorsqu'on tente de l'appelé avec une entrée "null", le test vérifie que l'exception envoyé est IllegalStateException et que le message renvoyé par l'exception est : "Debug information has to be none null". [Lien vers le test](src/test/java/com/graphhopper/util/GHResponseTest.java)