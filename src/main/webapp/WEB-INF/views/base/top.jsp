<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <style>
        .marker {
            border: 1px solid black;
            background: green;
            opacity: 0.8;
            width: 24px;
            height: 24px;
            border-radius: 50%;
        }

        .infowindow_wrap {
            background: white;
            padding: 20px;
            border: 1px solid rgba(0, 0, 0, 0.2);
        }

        .infowindow_title {
            font-size: 15px;
            font-weight: bolder;
        }

        .infowindow_content {
            font-size: 13px;
            font-weight: normal;
        }

        .infowindow_date {
            font-size: 13px;
            font-weight: normal;
        }

        .pulse {
            display: block;
            width: 22px;
            height: 22px;
            border-radius: 50%;
            cursor: pointer;
            box-shadow: 0 0 0 rgb(255, 0, 0);
            animation: pulse 1.7s infinite;
        }

        @keyframes pulse {
            0% {
                box-shadow: 0 0 0 0 rgba(204, 49, 44, 0.4);
                -moz-box-shadow: 0 0 0 0 rgba(204, 49, 44, 0.4);
            }

            70% {
                box-shadow: 0 0 0 20px rgba(204, 49, 44, 0);
                -moz-box-shadow: 0 0 0 20px rgba(204, 49, 44, 0);
            }

            100% {
                box-shadow: 0 0 0 0 rgba(204, 49, 44, 0);
                -moz-box-shadow: 0 0 0 0 rgba(204, 49, 44, 0);
            }
        }

        @-webkit-keyframes pulse {
            0% {
                box-shadow: 0 0 0 0 rgba(204, 49, 44, 0.4);
                -moz-box-shadow: 0 0 0 0 rgba(204, 49, 44, 0.4);
            }

            70% {
                box-shadow: 0 0 0 20px rgba(204, 49, 44, 0);
                -moz-box-shadow: 0 0 0 20px rgba(204, 49, 44, 0);
            }

            100% {
                box-shadow: 0 0 0 0 rgba(204, 49, 44, 0);
                -moz-box-shadow: 0 0 0 0 rgba(204, 49, 44, 0);
            }
        }
    </style>
    <script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
    <script type="text/javascript"
            src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=vdjcxltshu"></script>
</head>

<body>