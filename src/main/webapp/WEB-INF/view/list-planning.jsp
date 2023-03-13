<%@ page import="com.pack.spring_mvc.model.Plannings" %>
<%@ page import="java.util.List" %>
<%@ page import="com.pack.spring_mvc.model.V_Scenario" %>
<%
  List<List<Plannings>> allplanning=( List<List<Plannings>>)request.getAttribute("allplanning");
  String[]tempstravail={"Jour","Nuit"};
  int count=1;
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="navbar.jsp"/>
<div class="cs-sidebar_frame_right">
  <div class="container">
    <div class="row">
      huhu
      <div class="cs-white_bg cs-type1">
        <h2 class="page-title">Planning du Film</h2>
        <strong class="card-title">Planning</strong>
        <div class="row">
        </div> <!-- / .card -->
      </div>
    </div>
    <br/>
    <br/><!-- .col-12 -->
  </div>
  <div class="container">
    <div class="row">
      <%for(List<Plannings>plannings:allplanning){%>
      <% for(int j=0;j<plannings.size();j++){%>
      <% Plannings p=(Plannings) plannings.get(j);%>
      <div class="col-3">
        <h2 class="cs-widget_title"><span>Jour<%=(j+1)%></span> </h2>
        <div class="cs-tag_widget">
          <div class="row">
            <% for(V_Scenario v_scenario:p.getScenario()){%>
            <div class="cs-activity cs-gray_bg col-12">
              <div class="cs-activity_right">
                <p class="cs-activity_text">Scenario ref <span><%=v_scenario.getIdScenario()%> (<%=tempstravail[v_scenario.getTempstravail()-1]%>)</span></p>
                <p class="cs-activity_posted_by"><%=v_scenario.getDuree()%> </p>

              </div>
              <br/>
            </div>
            <br/>
            <br/>
            <br/>
            <% }%>
            <br/>
            <br/>
            <br/>
          </div>
          <% count++;%>
        </div>
      </div>
      <div class="col-1"></div>
      <% }%>
      <br/>
      <% }%>
    </div>
  </div>
  <jsp:include page="footer.jsp"/>
