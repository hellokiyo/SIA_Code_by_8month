<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>메신저 페이지</title>
<link href="assets/css/style.bundle.css" rel="stylesheet" type="text/css"/>
<script src="assets/js/scripts.bundle.js"></script>
</head>
<body>
<!--begin::Trigger button-->
<button id="kt_drawer_example_basic_button" class="btn btn-primary">Toggle advanced drawer</button>
<!--end::Trigger button-->

<!--begin::View component-->
<div
    id="kt_drawer_example_advanced"

    class="bg-white"
    data-kt-drawer="true"
    data-kt-drawer-activate="true"
    data-kt-drawer-toggle="#kt_drawer_example_advanced_button"
    data-kt-drawer-close="#kt_drawer_example_advanced_close"
    data-kt-drawer-name="docs"
    data-kt-drawer-overlay="true"
    data-kt-drawer-width="{default:'300px', 'md': '500px'}"
    data-kt-drawer-direction="start"
>
    ...
</div>
<!--end::View component-->
</body>
</html>