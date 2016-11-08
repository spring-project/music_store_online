<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Music Store Online</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="resources/css/bootstrap.min.css"/>" rel="stylesheet" />
    <link href="<c:url value="resources/css/slider.css"/>" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
</head>
<body>

    <!-- NAVBAR  -->
    <style>
        /* use navbar-wrapper to wrap navigation bar, the purpose is to overlay navigation bar above slider */
        .navbar-wrapper {
            position: absolute;
            top: 20px;
            left: 0;
            width: 100%;
            height: 51px;
        }
        .navbar-wrapper > .container {
            padding: 0;
        }

        @media all and (max-width: 768px ){
            .navbar-wrapper {
                position: relative;
                top: 0px;
            }
        }
    </style>
    
    <div class="navbar-wrapper">
        <div class="container">

            <nav class="navbar navbar-inverse navbar-static-top" role="navigation" style="margin-bottom: 0px;">
                <%@ include file="../includes/navbar.jsp"%>
            </nav>

        </div>
    </div>

    <div style="min-height: 50px;">
        <%@ include file="../includes/slider.jsp" %>
    </div>

    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">This page runs <a href="http://getbootstrap.com" target="_blank" rel="nofollow">Bootstrap</a> with Jssor Slider.</h2>
                <p class="lead">Use Jssor Slider as a compoment of Bootstrap is extremly easy. Given a carousel you worked out, to integrate it with Bootstrap, you can just copy javascript and html code and paste it into your page. This page is a simple demo, please view source of this page or download <a href="http://www.jssor.com/download-bootstrap-carousel-slider-example.html">Bootstrap Carousel Slider Example</a>.</p>
            </div>
            <div class="col-md-5">
                <img class="featurette-image img-responsive" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-5">
                <img class="featurette-image img-responsive" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
            </div>
            <div class="col-md-7">
                <h2 class="featurette-heading">Javascript Code</h2>
                <div class="lead" style="background-color:#f0f0f0; border: 1px dashed #000; white-space: nowrap;">
                    <pre style="margin:0px;">
&lt;script type="text/javascript" src="../js/jssor.slider.mini.js"&gt;&lt;/script&gt;
&lt;script&gt;
    jQuery(document).ready(function ($) {
        var options = {
            ..
        };
            
        var jssor_slider1 = new $JssorSlider$("slider1_container", options);
        ...
    });
&lt;/script&gt;</pre>
                </div>
            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">HTML Code</h2>
                <div class="lead" style="background-color:#f0f0f0; border: 1px dashed #000; white-space: nowrap;">
                    <pre style="margin:0px;">
&lt;div style="min-height: 50px;"&gt;
    &lt;!-- Jssor Slider Begin --&gt;
    &lt;div id="slider1_container" style="visibility: hidden; position: relative; margin: 0 auto; width: 980px; height: 380px; overflow: hidden;"&gt;
        ...
    &lt;/div&gt;
    &lt;!-- Jssor Slider End --&gt;
&lt;/div&gt;</pre>
                </div>
            </div>
            <div class="col-md-5">
                <img class="featurette-image img-responsive" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
            </div>
        </div>

        <hr class="featurette-divider">

        <!-- /END THE FEATURETTES -->
        <!-- FOOTER -->
        <footer>
            <p class="pull-right"><a href="#">Back to top</a></p>
            <p>&copy; Jssor Slider 2009 - 2016. &middot; <a href="#">Privacy</a> &middot; </p>
        </footer>

    </div><!-- /.container -->

    
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<c:url value="resources/js/jquery-1.9.1.min.js"/>"></script>
    <script src="<c:url value="resources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="resources/js/docs.min.js"/>docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="<c:url value="resources/js/ie10-viewport-bug-workaround.js"/>"></script>

    <!-- jssor slider scripts-->
    <!-- use jssor.slider.debug.js for debug -->
    <script type="text/javascript" src="<c:url value="resources/js/jssor.slider.mini.js"/>"></script>
    <script type="text/javascript" src="<c:url value="resources/js/slider.js"/>"></script>
</body>
</html>