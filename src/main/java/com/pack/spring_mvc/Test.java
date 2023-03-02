package com.pack.spring_mvc;

public class Test {
    public static void main(String[] args) throws Exception{
  /*      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        HibernateDAO dao = context.getBean(HibernateDAO.class);

        Vpublication vpublication = new Vpublication();
        long systemNow = System.currentTimeMillis();
        Date now = new Date(systemNow);
        Statut st = new Statut();
        st.setCode(1);

        vpublication.setStatut(st);

        Session session = dao.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Vpublication.class);
  //      Statut st = new Statut();
   //     st.setCode(1);

        Order orderByHomePage = Order.desc("isHomePage");
        Order orderByDatePublication = Order.desc("datepublication");

        criteria.add(Restrictions.eq("statut", st));
        criteria.add(Restrictions.lt("datepublication", now));
        List<Vpublication> response = criteria
                .addOrder(orderByHomePage)
                .addOrder(orderByDatePublication)
                .list();

        System.out.println("mety ve rty "+response.size());

        for(Vpublication vpublication1: response){
            System.out.println("huhu ::"+vpublication1.getId()+" et "+vpublication1.getTitre());
        }

//        Criteria criteria = session.createCriteria(Vpublication.class);

        criteria.add(Restrictions.eq("statut", st));
        criteria.add(Restrictions.lt("datepublication", now));



        Statut stt = new Statut();
        st.setCode(0);
        stt = dao.findWhere(st).get(0);

        System.out.println("stt response "+stt.getDesignation());


     //   List<Rubrique> rubriqueList = dao.findAll(Rubrique.class);

/*        List<Rubrique> rubriqueList = dao.findWhere(r);
        System.out.println("ee "+rubriqueList);

        for(Rubrique rubrique: rubriqueList){
            System.out.println("huhu ::"+rubrique.getNom()+" et "+rubrique.getId());
        }
*/
/*        String condition = "Vanya";

        String query = " where (titre like '%"+condition+"%') or (body like '%"+condition+"%')";
        List<Publication> response = dao.paginateWhere( new Publication(), 0, 1, query);
        for(Publication rubrique: response){
            System.out.println("huhu ::"+rubrique.getId());
        }

        context.close(); */

      /*  double r = (7/(6+0.0));
        System.out.println(r);
        int response = (int)Math.nextUp(2);
        System.out.println("page = "+Math.nextUp(2)); */
    }
}
