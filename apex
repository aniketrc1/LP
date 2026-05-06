public class StudentInfo {
    
    // Function 1 : Add Student
    public static void addStudent() {
        
        Student__c s = new Student__c();
        
        s.Name = 'Bharat';
        s.name__c = 'Bharat Patil';
        s.age__c = 20;
        s.city__c = 'Pune';
        s.email__c = 'bharat@gmail.com';
        
        insert s;
        
        System.debug('Student Added Successfully');
    }
    
    
    // Function 2 : View Student
    public static void viewStudent() {
        
        List<Student__c> list1 =
        [
            SELECT Name,
                   name__c,
                   age__c,
                   city__c,
                   email__c
            FROM Student__c
        ];
        
        for(Student__c s : list1) {
            
            System.debug('Student Name : ' + s.Name);
            System.debug('Full Name : ' + s.name__c);
            System.debug('Age : ' + s.age__c);
            System.debug('City : ' + s.city__c);
            System.debug('Email : ' + s.email__c);
        }
    }
    
    
    // Function 3 : Delete Student
    public static void deleteStudent() {
        
        Student__c s =
        [
            SELECT Id
            FROM Student__c
            LIMIT 1
        ];
        
        delete s;
        
        System.debug('Student Deleted Successfully');
    }
}