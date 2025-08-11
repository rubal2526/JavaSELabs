package workshop.oop.flexible;

public class InFlexibleCompanyDemo {
    public static void main(String[] args) {
        
        MereClerk mereClerk1 = new MereClerk("ö��", 100);
        MereClerk mereClerk2 = new MereClerk("����", 100);
        Manager manager = new Manager("ȫ�浿", 200);
        
        //�ڽ� mgr = new �ڽ�
        Manager hrmgr = new Manager("�Ѹ�",200,"HR");
        System.out.println(hrmgr.getName());
        System.out.println(hrmgr.getSalary());
        System.out.println(hrmgr.getDept());
        
        //������(Polymorphism) Poly(�پ缺) + Morphism(����,����)
        Employee itMgr = new Manager("�浿", 250, "IT");
        System.out.println(itMgr.getName());
        System.out.println(itMgr.getSalary());
        
        //Manager(�ڽ�)�� ���� getDept() �޼��� ȣ���ϱ�
        Manager itMgr2 = (Manager)itMgr;
        System.out.println(itMgr2.getDept());
        //((Manager)itMgr).getDept();
        
        //Heterogeneous Collection Employee
        //emps ������ Employee[] Ÿ��, emps[0]�� Employee Ÿ��
        Employee[] emps = new Employee[4];
        emps[0] = new Manager("�浿", 250, "IT");
        emps[1] = new MereClerk("ö��", 100);
        emps[2] = new MereClerk("����", 100);
        emps[3] = new Manager("�Ѹ�",200,"HR");
        
        System.out.println("���� �����Դϴ�.");
        printEmployeeinfo(emps);
        
        for(Employee emp: emps) {
        	emp.manageSalary(10);
        }
        
        System.out.println("�ø� ���� �����Դϴ�.");
        printEmployeeinfo(emps);
   }

	private static void printEmployeeinfo(Employee[] emps) {
		for(Employee emp: emps) {
			//emp�� Manager��ü�κ��� ������� instance ���ڸ� üũ�ϴ� ������
			if(emp instanceof Manager) {
				//((Manager)itMgr).getDept();
				System.out.println("������ �μ���= " + ((Manager)emp).getDept() + " ");
			}
        	System.out.println(emp.getName() + "�� ���� ������ " + emp.getSalary() + " ���� �Դϴ�.");
        }
	}
}

