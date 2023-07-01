
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="Head.jsp"%>

    </head>
    <body id="reportsPage">

        <nav class="navbar navbar-expand-xl">
            <%@include file="Header.jsp" %>
        </nav>
        <div class="input-group mt-5 col-xl-12">
            <h1 style="color: white; margin-left: 43%;">Dash Board</h1>
        </div>
        <div class="" id="home">
            
            

            <div class="container">
                <div class="row">
                    <div class="col">
                        <p class="text-white mt-5 mb-5">Welcome back, <b>Admin</b></p>
                    </div>
                </div>
                <div  class="row text-center d-flex justify-content-center">
                    <div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
                        <div class="dashboard-summary">
                            <h4>Number of anime</h4>
                            <span>${requestScope.totalAnime}</span>
                        </div>

                    </div>
                    <div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
                        <div class="dashboard-summary">
                            <h4>Revenue</h4>
                            <span>${totalMoney}</span>
                        </div>

                    </div>
                    <div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
                        <div class="dashboard-summary">
                            <h4>Total user</h4>
                            <span>${totalUser}</span>
                        </div>


                    </div>
                    <div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
                        <div class="dashboard-summary">
                            <h4>Total comment</h4>
                            <span>${totaComment}</span>
                        </div>


                    </div>

                </div>
                <!-- row -->
                <div style="margin-top:50px" class="row tm-content-row">
                    <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                        <div class="tm-bg-primary-dark tm-block">
                            <h2 class="tm-block-title">Latest Hits</h2>
                            <canvas id="lineChart"></canvas>
                        </div>
                    </div>
                    <div style="display: none;" class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                        <div class="tm-bg-primary-dark tm-block">
                            <h2 class="tm-block-title">Performance</h2>
                            <canvas id="barChart"></canvas>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                        <div class="tm-bg-primary-dark tm-block tm-block-taller">
                            <h2 class="tm-block-title">Total User In Website</h2>
                            <div id="pieChartContainer">
                                <canvas id="pieChart" class="chartjs-render-monitor" width="200" height="200"></canvas>
                            </div>                        
                        </div>
                    </div>

                </div>
            </div>
            <footer class="tm-footer row tm-mt-small">
                <div class="col-12 font-weight-light">
                    <p class="text-center text-white mb-0 px-4 small">
                        Copyright &copy; <b>2018</b> All rights reserved. 

                        Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
                    </p>
                </div>
            </footer>
        </div>

        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/moment.min.js"></script>
        <!-- https://momentjs.com/ -->
        <script src="js/Chart.min.js"></script>
        <!-- http://www.chartjs.org/docs/latest/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script src="js/tooplate-scripts.js"></script>
        <script>
            Chart.defaults.global.defaultFontColor = 'white';
            let ctxLine,
                    ctxBar,
                    ctxPie,
                    optionsLine,
                    optionsBar,
                    optionsPie,
                    configLine,
                    configBar,
                    configPie,
                    lineChart;
            barChart, pieChart;
            // DOM is ready
            $(function () {
                drawLineChart(); // Line Chart
                drawBarChart(); // Bar Chart
                drawPieChart(${admin}, ${vip}, ${user}); // Pie Chart

                $(window).resize(function () {
                    updateLineChart();
                    updateBarChart();
                });
            })
        </script>

        <style>
            .dashboard-summary{
                background-color: #ffffff;
                padding: 10%;
                border-radius: 10px;
                border: solid 3px black;
            }
            
            .dashboard-summary h4{
                font-size: 25px;
                font-weight: 900;
            }
            
            .dashboard-summary span{
                margin-top: 35%;
                font-size: 20px;
            }

        </style>
    </body>
</html>
