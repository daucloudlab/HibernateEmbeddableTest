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

            Address address = new Address("Сатпаев 22a", "Алматы", "060067") ;
            Person person = new Person("Дәулет", address) ;

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
