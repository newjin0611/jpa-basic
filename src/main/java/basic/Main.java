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

            Member member1 = new Member();
            member1.setUsername("member1");
//            member1.chaneTeam(team); //굳이 양방향 셋팅을 하고 싶다면 Team 에 넣지 말고 연관관계 편의 메서드 사용
            em.persist(member1);

            Team team = new Team();
            team.setName("team1");
            team.addMember(member1);
            em.persist(team);

            em.flush();
            em.clear();
//
//            Member findMember = em.find(Member.class, member1.getId());
//            List<Member> findMembers =
//                    findMember.getTeam().getMembers();
//            for(Member member : findMembers ){
//                System.out.println("findMembers = " + member.getUsername());
//            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}