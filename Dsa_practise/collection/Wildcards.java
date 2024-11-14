package collection;
import java.util.List;
import java.util.ArrayList;

class Student {
	
	void print() {
		System.out.println("Student");
	}
}

class EnggStudent extends Student{
	
	void print() {
		System.out.println("He is an Engineering Student");
	}
}

class MedicalStudent extends Student {
	
	void print() {
		System.out.println("She is a medical student");
	}
}

public class Wildcards {
	
	void print(List<? extends Student> list) {
		
		for(Student s: list) {
			s.print();
		}
	}
	
	
	
	public static void main(String args[]) {
		Wildcards wildcard = new Wildcards();
		List<EnggStudent> engglist = new ArrayList<>();
		engglist.add(new EnggStudent());
		engglist.add(new EnggStudent());
		engglist.add(new EnggStudent());
		List<MedicalStudent> medlist = new ArrayList<>();
		medlist.add(new MedicalStudent());
		medlist.add(new MedicalStudent());
		wildcard.print(engglist);
		wildcard.print(medlist);
		
	}
}
