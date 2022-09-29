<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>semi project viewpage</title>
    <link rel="stylesheet" href="css/view.css" />
  </head>
  <body>
    <div id="bg">
      <div class="container">
        <div class="row">
          <table>
            <th>
              <tr>
                <td colspan="2" id="title">게시판</td>
                <input type="button" class="backBtn" value="< " />
              </tr>
            </th>
          </table>
          <hr />
          <p id="writer" colspan="2">
            ${vo2.writer}

            <button>
              <a  href="b_boardUpdate.do?board_id=${param.board_id}">📝</a>
            </button>
            <button>
              <a class="delete" href="b_boardDelete.do?board_id=${param.board_id}">🗑️</a>
            </button>
          </p>

          <hr />
          <p id="title" colspan="2">${vo2.title}</p>
          <p id="contents" colspan="3" style="min-height: 200px">
            ${vo2.contents}

            <div class="modal">
                <button> <a href="b_view.do?board_id=${param.board_id}"></a> x</button>
                <h1>정말 삭제하시겠습니까?</h1>
                <a href="b_boardDeleteOK.do?board_id=${param.board_id}">네 삭제하겠습니다</a>

            </div>

          </p>
        </div>
        <div class="overlay"></div>
      </div>
    </div>
    <script>
console.log("sessionStorage:", sessionStorage.user_id);
console.log("localStorage:", localStorage.user_name);

const deleteBtn = document.querySelector('.delete')
const showModal = document.querySelector('.modal');

const openmodal = function(){
    showModal.classList.remove('hidden');
}

deleteBtn.addEventListener('click',openmodal)


const images = ["prof1.png", "prof2.png", "prof3.png"];
const body = document.querySelector("#writer");
const IMG_NUMBER = images.length;
const chosenImg = images[Math.floor(Math.random() * images.length)];
function chaPho(IMG_NUMBER) {
  const image = new Image();
  image.classList.add("profImg");
  body.appendChild(image);
  image.src = `png/${chosenImg}`;
  }
function inti() {
    chaPho(Math.floor(Math.random() * images.length));
    }
inti();

    </script>
  </body>
</html>
