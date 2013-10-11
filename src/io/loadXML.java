/**
 * Basic load functionality for course and student information
 * author: Brett Story
 */
package io;

import objects.*;

import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class loadXML {
	
    // Student array to be loaded
    static List<String> studentNames = new ArrayList<String>();
    static List<String> studentPsuedoNames = new ArrayList<String>();
    
    // Grade stuff
    static ArrayList<ArrayList<String>> assignments = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<Integer>> grades = new ArrayList<ArrayList<Integer>>();
    
    private static MyCourse loadCourseInfo() {   
    	
    	MyCourse course = new MyCourse(null);
    	
    	try {
            // Initial setup of document parser         
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File("structure.xml"));
            
            // normalize text representation
            doc.getDocumentElement().normalize();
            
            /* ------------------------------
             * Section for courseName 
             * -------------------------------*/
            NodeList courseNameList = doc.getElementsByTagName("courseName");
            Node courseNameNode = courseNameList.item(0);
            
            //Note: you must do .getFirstChild().getNodeValue() to return what's inside the tags
            course.setName(courseNameNode.getFirstChild().getNodeValue());
        
            /* ------------------------------
             * Section for courseID/#/Section
             * -------------------------------*/
            NodeList courseIDList = doc.getElementsByTagName("courseID");
            Node courseIDNode = courseIDList.item(0);
            
            course.setCourseID(courseIDNode.getFirstChild().getNodeValue());
            
            NodeList courseNumberList = doc.getElementsByTagName("courseNumber");
            Node courseNumberNode = courseNumberList.item(0);
            
            course.setCourseNumber(Integer.parseInt(courseNumberNode.getFirstChild().getNodeValue()));
            
            NodeList sectionList = doc.getElementsByTagName("section");
            Node sectionNode = sectionList.item(0);
            
            course.setSection(sectionNode.getFirstChild().getNodeValue());
            
            /* ------------------------------
             * Section for building/roomNumber
             * -------------------------------*/
            
            NodeList buildingList = doc.getElementsByTagName("building");
            Node buildingNode = buildingList.item(0);
            
            course.setBuilding(buildingNode.getFirstChild().getNodeValue());
            
            NodeList roomIDList = doc.getElementsByTagName("roomID");
            Node roomIDNode = roomIDList.item(0);
            
            course.setRoomID( roomIDNode.getFirstChild().getNodeValue());
            
            /* ------------------------------
             * Section for meetingTime
             * -------------------------------*/
            
            NodeList meetingTimeList = doc.getElementsByTagName("meetingTime");
            Node meetingTimeNode = meetingTimeList.item(0);
            
            course.setMeetingTime(meetingTimeNode.getFirstChild().getNodeValue());
            
        //Beyond this point are all catches
        }catch (SAXParseException err)
        {
            System.out.println("** Parsing error" + ", line " +
                    err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());
            
        }catch (SAXException e) {
            // TODO Auto-generated catch block
            Exception x = e.getException();
            ((x == null) ? e: x).printStackTrace();
            
        }catch (Throwable t) {
            // TODO Auto-generated catch block
            t.printStackTrace();
        }
        return course;
    }
    
    private static void loadStudentInfo() {
        
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler() {
                
                boolean name = false;
                boolean psuedoName = false;
                
                // A SAX callback method which finds the start of an XML element
                public void startElement (String uri, String localName, String qName,
                    Attributes attributes) throws SAXException {
                    
                    if (qName.equalsIgnoreCase("name")) {
                        name = true;
                    }
                    
                    if (qName.equalsIgnoreCase("psuedoName")) {
                        psuedoName = true;
                    }
                }
                
                // A SAX callback method which finds the end of an XML element
                public void endElement(String uri, String localName, 
                    String qName) throws SAXException {
                    
                }
                
                // A SAX callback method which contains all the characters in an element
                public void characters(char ch[], int start, int length) 
                    throws SAXException {
                    //If the element is <name>
                    if (name) {
                        studentNames.add(new String(ch, start, length));
                        name = false; // must declare name false for next search
                    }
                    //If the element is <psuedoName>
                    if (psuedoName) {
                        studentPsuedoNames.add(new String(ch, start, length));
                        psuedoName = false;                     
                    }
                }
                
            };
            
            saxParser.parse("structure.xml", handler);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    private static void loadAssignmentInfo() {
        
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler() {
                boolean assignmentName = false;
                boolean category = false;
                boolean grade = false;
                
                // A SAX callback method which finds the start of an XML element
                public void startElement (String uri, String localName, String qName,
                    Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("assignment")) {
                        assignments.add(new ArrayList<String>());
                        grades.add(new ArrayList<Integer>());
                    }
                    if (qName.equalsIgnoreCase("assignmentName")) {
                        assignmentName = true;
                    }
                    if (qName.equalsIgnoreCase("category")) {
                        category = true;
                    }
                    
                    if (qName.equalsIgnoreCase("grade")) {
                        grade = true;
                    }
                }
                
                // A SAX callback method which finds the end of an XML element
                public void endElement(String uri, String localName, 
                    String qName) throws SAXException {
                }
                
                // A SAX callback method which contains all the characters in an element
                public void characters(char ch[], int start, int length) 
                    throws SAXException {
                    //If the element is <name> within <assignment>
                    if (assignmentName) {
                        assignments.get(assignments.size() - 1).add(new String(ch, start, length));
                        assignmentName = false; // must declare name false for next search
                    }
                    //If the element is <category> within <assignment>
                    if (category) {
                        assignments.get(assignments.size() - 1).add(new String(ch, start, length));
                        category = false;                     
                    }
                    //If the element is <grade> within <assignment>
                    if (grade) {
                        grades.get(grades.size() - 1).add(Integer.parseInt(new String(ch, start, length)));
                        grade = false; // must declare name false for next search
                    }
                }
                
            };
            
            saxParser.parse("structure.xml", handler);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String argv[]) {   	    	
        // Loads course info, non-iterative things
        MyCourse course = loadCourseInfo();
        
        /* -------------------------------------------------------
         * Printing stuff for testing, delete before final build
         * -------------------------------------------------------*/
        System.out.println("Course Name: " + course.getName());
        System.out.println("Course ID: " + course.getCourseID() + course.getCourseNumber() + "-" + course.getSection());
        System.out.println("Room: " + course.getBuilding() + " " + course.getRoomID());
        System.out.println("Meeting Time: " + course.getMeetingTime());
            
        // Loads students and their information
        loadStudentInfo();
        
        for (int i = 0; i < studentNames.size() - 1; i++) {
            System.out.println("NAME: " + studentNames.get(i));
            System.out.println("PSUEDONAME: " + studentPsuedoNames.get(i));
        }
        
        loadAssignmentInfo();
                
        for (ArrayList<String> assignment : assignments) {
            System.out.println("Assignment Name: " + assignment.get(0));
            System.out.println("Assignment Category: " + assignment.get(1));
            
            for(int i = 0; i < grades.get(assignments.indexOf(assignment)).size(); i++) {
                System.out.println("GRADE: " + grades.get(assignments.indexOf(assignment)).get(i));
            }
        }
        
    }
}
