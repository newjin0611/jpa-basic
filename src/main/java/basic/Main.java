package basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Team team = new Team();
            team.setName("AA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("aa");
            member.setTeam(team);
            em.persist(member);

//            em.flush();
//            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();

            System.out.println("findTeam=" + findTeam.getName());


            Team newTeam = em.find(Team.class, 4L);
            findMember.setTeam(newTeam);
            em.persist(findMember);


//            Team team = new Team();
//            team.setName("teamC");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("C");
//            member.setTeam(team);
//            em.persist(member);

//            System.out.println("==============1");
//
//            Member findMember = em.find(Member.class, member.getId());
//            Team findTeam = findMember.getTeam();
//
//            System.out.println("==============2");
//
//            System.out.println("findTeam = " + findTeam);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}