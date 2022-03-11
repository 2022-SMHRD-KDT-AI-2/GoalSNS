<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
    <nav class="navbar navbar-default bg-primary navbar-fixed-top">
        <div class="menu-box">
            <div class="container-fluid">
                <div class="navbar-header">
                
                  <a class="navbar-brand" href="/goalsns/main.do"><img src="./resources/images/logo.png" height="50px"></a>
                </div>
                <form class="navbar-form navbar-left" action="/goalsns/search.do">
                    <div class="form-group">
                      <input type="text" class="form-control" placeholder="검색" name="search">
                    </div>
                    <button type="submit" class="btn btn-default"><i class="fa-solid fa-magnifying-glass"></i></button>
                </form>
              <div class="test">
                <ul class="nav navbar-nav">
                  <li><a href="/goalsns/main.do"><i class="fa-solid fa-house"></i></a></li>
                  <li><a href="/goalsns/postWrite.jsp"><i class="fa-regular fa-square-plus"></i></a></li>
                  <li><a href="/goalsns/profile.do?mem_id=${memvo.mem_id}"><img class="img-circle" src="./profilePic/${memvo.mem_img}" width=26.5px height=26.5px></a></li>
                  <li><a href="/goalsns/logout.do"><i class="fa-solid fa-arrow-right-from-bracket"></i></i></a></li>
                </ul>
              </div>
              </div>
        </div>
    </nav>
    

