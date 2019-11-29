<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>저 행복해요</title>
        
        <style>
        	<%@ include file="/css/happyBoard/happyBoardWriter.css" %>
        </style>
    </head>
    
    <body>
        <div class="wrap">
            <form action="happyBoardWriter.do" method="POST" enctype="multipart/form-data">
                <div class="header">
                    <img src="showIcon.png">
                    <div>글쓰기</div>
                </div>
                
                <div class="title">
                    <div>😻 저 행복해요 :</div>
                    <input type="text" name="title" placeholder="제목을 적어주세요">
                </div>
                
                <textarea rows="30" cols="92" name="content"></textarea>
                
                <div class="files">
                    <div>📷 사진을 올려요 (🗑 사진을 클릭하면 취소되요)</div>
                    
                    <div class="fileWrap">    
                        <input type="file" name="file1" class="file1 fileInput">
                    </div>
                    
                    <div class="fileWrap">    
                        <input type="file" name="file2" class="file2 fileInput">
                    </div>
                    
                    <div class="fileWrap">    
                        <input type="file" name="file3" class="file3 fileInput">
                    </div>
                </div>
                
                <div class="confirm">
                    <input type="submit" value="등록하기">
                    <input type="button" value="취소" onclick="cancel()">
                </div>
                
                <div class="imgWrap">
                    <img class="file1" style="width: 150px">
                    <img class="file2" style="width: 150px">
                    <img class="file3" style="width: 150px">
                </div>
            </form>
        </div>
        
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
        <script>
            $(document).ready(function() {
                $(".fileDelete").click(function() {
                    $(this).prev().val("");
                    
                    img = "img." + $(this).attr("name");
                    $(img).attr("src", "");
                });
                
                
                $(".fileInput").change(function() {
                    const file = this.files[0];
                    
                    if(file) {
                        img = "img." + $(this).attr("name");
                        
                        const fileReader = new FileReader();
                        $(fileReader).load(function() {
                            $(img).attr("src", this.result);
                        });
                        
                        fileReader.readAsDataURL(file);
                        
                    } else {
                        $(img).attr("src", "");
                    }
                });
                
                
                $(".imgWrap img").click(function() {
                    const thisClassName = $(this).attr("class");
                    const thisImg = $(".imgWrap ." + thisClassName);
                    const thisInput = $(".fileWrap ." + thisClassName);
                    
                    $(thisImg).removeAttr("src");
                    $(thisInput).val("");
                });
            });
            
            function cancel() {
                history.back();
            }
        </script>        
    </body>
</html>
