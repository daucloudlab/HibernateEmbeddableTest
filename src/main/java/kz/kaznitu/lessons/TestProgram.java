package kz.kaznitu.lessons;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestProgram {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory() ;
        Session session = sessionFactory.openSession() ;

        Transaction transaction = session.getTransaction() ;
        try{
            transaction.begin() ;

            Address billindAddress = new Address("Сатпаев 22a", "Алматы", "060067") ;
            Address homeAddress = new Address("Алмалы 18", "Алматы", "060054") ;
            Person person = new Person("Дәулет", homeAddress, billindAddress) ;

            session.persist(person);

            transaction.commit();

        }catch (Exception e){
            if(transaction!=null)
                transaction.rollback();
            e.printStackTrace();
        }finally {
            if(session != null)
                session.close();
        }
    }
}
