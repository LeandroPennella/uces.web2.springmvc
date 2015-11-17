<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>jQuery UI Autocomplete - Remote JSONP datasource</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script type="text/javascript" src='<c:url value="/js/jquery-1.8.2.js" />'></script>
  <script type="text/javascript" src='<c:url value="/js/jquery-ui-1.11.4/jquery-ui.min.js" />'></script>
  
  
  <style>
  
  #city { width: 25em; }
  </style>
  <script>
  $(function() {
    function log( message ) {
      $( "<div>" ).text( message ).prependTo( "#log" );
      $( "#log" ).scrollTop( 0 );
    }
 
    $( "#city" ).autocomplete({
      source: function( request, response ) {

        $.ajax({
        	
          url : '<c:url value="/services/getByValue" />?value='+request.term,
          dataType: "json",
          success: function( data ) {
            response( data );
          }
        });
      }})});
  </script>
</head>
<body>
 
<div class="ui-widget">
  <label for="city">Your city: </label>
  <input id="city">
  Powered by <a href="http://geonames.org">geonames.org</a>
</div>
 
<div class="ui-widget" style="margin-top:2em; font-family:Arial">
  Result:
  <div id="log" style="height: 200px; width: 300px; overflow: auto;" class="ui-widget-content"></div>
</div>
 
 
</body>
</html>