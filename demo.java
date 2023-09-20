import java.lang.reflect.*;
import java.lang.annotation.*	;
public class demo {
	
public static void main(String args[]){

System.out.println("hello world from demo");
Person p =new Person("nikhil","jain");
System.out.println(p);	

Student s = new Student("umesh","wankhedkar","physics",30);
System.out.println(s);


MyCalculator myc= new MyCalculator();

System.out.println(myc.sum(3,4));

Class c= MyCalculator.class;

Method m[] =c.getMethods();
int x=0;

System.out.println(m[0].getName());


try{
Constructor con[]=c.getConstructors();
Method met[]=c.getMethods();


System.out.println(con.length+"  "+con[0].getName()+con[0].getParameterTypes()[0].getName());

MyCalculator myobject=(MyCalculator)con[0].newInstance(0,"hi");


for(Method methd:met){

Annotation ann[] = methd.getDeclaredAnnotations();

for(Annotation an: ann){
System.out.println("annotation  are "+an.annotationType());
}


}


}

catch(Exception e){
e.printStackTrace();
}
}




}




@interface myannot{

}


interface calculator{
  
  int sum(int one, int two);
}


class MyCalculator implements calculator{


MyCalculator(){
System.out.println("default constructor invoked");
}


public MyCalculator(int x, String y ){
System.out.println("prammeterized constructor");
}


@myannot
public int sum(int one ,int two){
return one+two;
}

}




class Person {

String name="";
String lastName="";

Person(String name,String lastname){

this.name=name;
this.lastName=lastname;
}

public String toString(){
return "Person name is "+this.name +" "+this.lastName;
}

}



class Student extends Person{

String department="";
int rollno=0;

Student(String name, String lastname,String department,int rollno){
super(name,lastname);
this.department=department;
this.rollno=rollno;
}

public String toString(){

return "this student belongs to"+this.department;
}

}