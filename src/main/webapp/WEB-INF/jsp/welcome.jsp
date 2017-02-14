<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/webjars/jquery-ui/1.12.1/themes/base/jquery-ui.min.css"
    <link rel="stylesheet" type="text/css" href="/webjars/github-com-mar10-fancytree/2.21.0/dist/skin-win8/ui.fancytree.min.css" />


    <script type="text/javascript" src="/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
    <script type="text/javascript" src="/webjars/github-com-mar10-fancytree/2.21.0/dist/jquery.fancytree-all.min.js"></script>


    <script type="text/javascript">

        $(document).ready(function(){

            // Load tree from Ajax JSON
            $("#tree2").fancytree({
                  source: {
                    url: "ajax-tree-plain.json"
                  },
                  lazyLoad: function(event, data){
                    data.result = $.ajax({
                      url: "ajax-sub2.json",
                      dataType: "json"
                    });
                  }
            });

        });

    </script>

    <c:url value="/css/main.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot Fancy Tree</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

    <div class="container">
        <div class="row">
            <div class="col-lg-6">

            <div id="fancyTreeDivId" data-source="ajax" class="sampletree">

            </div>

            </div>
            <div class="col-lg-6">
                Container Right
            </div>
        </div>
    </div>

	<!-- /.container -->



</body>

</html>
