"use strict";
const pw = document.querySelector("#pwa");
const pwCheck = document.querySelector("#pw");
const ageCheck = document.getElementById("age");
const golfAvgCheck = document.getElementById("golfAvgCheck");
const genderCheck = document.getElementById("gender");
const locCheck = document.getElementById("loc");
const submitBtn = document.getElementById("insert");

const joinValues = function () {
  //비밀번호 확인
  if (pw.value !== pwCheck.value) {
    alert("비밀번호가 다릅니다");
  }
  //연령대 구분
  if (ageCheck.value < 20) {
    ageCheck.value = "10대";
  } else if (ageCheck.value < 30) {
    ageCheck.value = "20대";
  } else if (ageCheck.value < 40) {
    ageCheck.value = "30대";
  } else if (ageCheck.value < 50) {
    ageCheck.value = "40대";
  } else if (ageCheck.value > 50) {
    ageCheck.value = "50대 이상";
  }
  //평균타수 구분
  if (golfAvgCheck.value < 70) {
    golfAvgCheck.value = "프로 플레이어";
  } else if (golfAvgCheck.value < 80) {
    golfAvgCheck.value = "싱글 플레이어";
  } else if (golfAvgCheck.value < 90) {
    golfAvgCheck.value = "보기 플레이어";
  } else if (golfAvgCheck.value > 90) {
    golfAvgCheck.value = "초보";
  }
};
submitBtn.addEventListener("click", joinValues);

//중복확인
window.onload = function () {
  console.log("onload....");
  let btn_idCheck = document.querySelector("#btn_idCheck");
  let btn_nickCheck = document.querySelector("#btn_nickCheck");
  //   let result = document.querySelector("#result");
  // console.log(result);

  btn_nickCheck.onclick = function (event) {
    console.log("onclick....");
    let nick = document.querySelector("#nick");
    // console.log(id);
    console.log(nick.value);

    let req = new XMLHttpRequest();

    req.addEventListener("load", function () {
      console.log(this.status);
      console.log(this.responseText);
      //{"result":"Not OK"}
      if (this.status == 200) {
        try {
          let txt_json = this.responseText;
          let obj_json = JSON.parse(txt_json);
          console.log(obj_json);
          console.log(obj_json.result);

          let txt = "";
          if (obj_json.result === "Not OK") {
            txt = "사용중.";
          } else {
            txt = "사용가능.";
          }
          btn_nickCheck.innerHTML = txt;
        } catch (e) {
          console.log("json 형식이 아님.");
        }
      } //end if
    });

    req.open(
      "GET",
      "http://localhost:8090/semi_project/json_nickCheck.do?nick=" + nick.value
    );
    req.send();

    event.preventDefault();
    event.stopPropagation();
  };

  btn_idCheck.onclick = function (event) {
    console.log("onclick....");
    let id = document.querySelector("#id");
    // console.log(id);
    console.log(id.value);

    let req = new XMLHttpRequest();

    req.addEventListener("load", function () {
      console.log(this.status);
      console.log(this.responseText);
      //{"result":"Not OK"}
      if (this.status == 200) {
        try {
          let txt_json = this.responseText;
          let obj_json = JSON.parse(txt_json);
          console.log(obj_json);
          console.log(obj_json.result);

          let txt = "";
          if (obj_json.result === "Not OK") {
            txt = "사용중.";
          } else {
            txt = "사용가능.";
          }
          btn_idCheck.innerHTML = txt;
        } catch (e) {
          console.log("json 형식이 아님.");
        }
      } //end if
    });

    req.open(
      "GET",
      "http://localhost:8090/semi_project/json_idCheck.do?id=" + id.value
    );
    req.send();

    event.preventDefault();
    event.stopPropagation();
  };
};
