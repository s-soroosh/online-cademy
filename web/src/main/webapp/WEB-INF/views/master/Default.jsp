<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/resources/yaml/core/iehacks.css" var="iehacksUrl"></spring:url>
<spring:url value="/resources/rtl-support.css" var="rtlSuppotCssUrl"></spring:url>
<spring:url value="/resources/yaml/core/js/yaml-focusfix.js" var="focusfixUrl"></spring:url>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="rtl">
<head>
    <meta charset="utf-8"/>
    <title>Demo: RTL Support &ndash; YAML CSS Framework</title>

    <!-- Mobile viewport optimisation -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- (en) Add your meta data here -->
    <!-- (de) Fuegen Sie hier ihre Meta-Daten ein -->

    <link href="${rtlSuppotCssUrl}" rel="stylesheet" type="text/css"/>
    <!--[if lte IE 7]>
    <link href="${iehacksUrl}" rel="stylesheet" type="text/css"/>
    <![endif]-->

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body class="demo-2col" style="padding-top:30px;">
<div style="">

    <nav style="position:fixed; width:100%;left:0px; top:0px;" id="nav">
        <div class="ym-hlist">
            <form class="ym-searchform">
                <input class="ym-searchbutton" value="Search" type="submit">
                <input class="ym-searchfield" placeholder="Search..." type="search">
            </form>
            <ul>
                <li><a href="#"></a></li>
           <%--     <li class="active"><strong>Active</strong></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>--%>
                <c:forEach items="${menu}" var="m">
                    <li><a href="#">${m}</a></li>
                </c:forEach>
            </ul>
        </div>
    </nav>
</div>
<ul class="ym-skiplinks">
    <li><a class="ym-skip" href="#nav">Skip to navigation (Press Enter)</a></li>
    <li><a class="ym-skip" href="#main">Skip to main content (Press Enter)</a></li>
</ul>

<div class="ym-wrapper">
    <div id="main">
        <div class="ym-column linearize-level-1">
            <div class="ym-col1">
                <tiles:insertAttribute name="body"/>
            </div>
            <aside class="ym-col3">
                <div class="ym-cbox">
                    <h2>Sidebar</h2>
                    <h4>Widget A</h4>
                    <ul>
                        <li>Item 1</li>
                        <li>Item 2</li>
                        <li>Item 3</li>
                        <li>Item 4</li>
                        <li>Item 5</li>
                    </ul>
                    <h4>Widget B</h4>
                    <ul>
                        <li>Item 1</li>
                        <li>Item 2</li>
                        <li>Item 3</li>
                    </ul>
                    <h4>Widget C</h4>
                    <ul>
                        <li>Item 1</li>
                        <li>Item 2</li>
                        <li>Item 3</li>
                    </ul>
                </div>
            </aside>
        </div>
    </div>
    <footer>
        <p>© Company 2012 &ndash; Layout based on <a href="http://www.yaml.de">YAML</a></p>
    </footer>
</div>
</div>

<!-- full skip link functionality in webkit browsers -->
<script src="${focusfixUrl}"></script>
</body>
</html>
