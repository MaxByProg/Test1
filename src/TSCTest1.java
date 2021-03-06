/**
 * Created by mbikov on 25.07.2017.
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TSCTest1 {
    static String filepath1 = "dep1.xml";
    static String filepath2 = "dep2.xml";
    static List<Integer> salaries1 = new ArrayList<Integer>();
    static List<Integer> salaries2 = new ArrayList<Integer>();
    static List<String> fios1 = new ArrayList<String>();
    static List<String> fios2 = new ArrayList<String>();
    static List<String> result1 = new ArrayList<>();
    static List<String> result2 = new ArrayList<>();

    public static void main(String[] args) {
        justDoIt();
    }

    //алгоритм решения
    public static void justDoIt() {

        // цикл для чтения потоков
        try {
            int counter = 0;
            while(counter < 3) {
                Thread thread1 = new Thread(new Thread1());
                thread1.start();
                Thread thread2 = new Thread(new Thread2());
                thread2.start();
                Thread.sleep(5000);
                counter++;
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //метод для считывания файла и вывода его в массив
    public static void doIt(String filepath, List<Integer> salaries, List<String> fios) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        File xmlFile = new File(filepath);
        DocumentBuilder builder;
        try {
            int re;

            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());
            // получаем узлы с именем event, теперь XML полностью загружен в память в виде объекта Document
            NodeList nodeList = document.getElementsByTagName("event");

            //массивы, куда загружаются данные из xml файлов
            List<String> xmlList = new ArrayList<>();

            // создадим список объектов event
            List<event> events = new ArrayList<event>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                events.add(getEvent(nodeList.item(i)));
            }

            for (event e : events) {
                xmlList.add(e.toString());
            }
            // циклы для создания новых массивов
            for(String line: xmlList){
                String strEnd=line.replaceAll("\\D",""); // удаляем все буквы и помещаем в массив для зп
                re = Integer.parseInt(strEnd);
                salaries.add(re);
                String word = line.replaceAll("[a-zA-Z-0-9-:-=-]+", ""); // помещаем в массив с ФИО
                fios.add(word);
            }

        } catch (NumberFormatException e) {
            System.out.println("Не указаны зарплаты либо сотрудники");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // создаем из узла документа объект event
    public static event getEvent(Node node) {
        event e = new event();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            e.setName(getTagValue("Name", element));
            e.setSalary(Integer.parseInt(getTagValue("Salary", element)));
        }

        return e;
    }

    // получаем значение элемента по указанному тегу
    public static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    //Метод для расчета средней зп
    public static int average (List<Integer> list){
        int sum = 0;
        int count = 0;
        for(int i: list){
            sum+= i;
            count++;
        }
        return sum/count;
    }

    //выводим массив dep3 в xml файл с помощью декодера
    public static void xmlEncoder(List<String> result , int id) throws FileNotFoundException {
        XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("result" + id + ".xml")));
        e.writeObject(result);
        e.close();
    }

    //config.properties
    /*public static String[] properties() {
        Properties property = new Properties();
        FileInputStream fis;
        String[] file = new String[3];
        try {
            fis = new FileInputStream("src\\resources\\config.properties");
            property.load(fis);
            file[0] = property.getProperty("dep1");
            file[1] = property.getProperty("dep2");
            file[2] = property.getProperty("out");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return file;
    }*/
}



