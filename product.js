get();
const content = document.getElementById("tbData");
var updateId = "";
async function get() {
  const getValue = await fetch("http://localhost:8080/get");
  var response = await getValue.json();
  var data = "";
  response.forEach((user) => {
    data += "<tr>";
    data += "<td>" + user.name + "</td>";
    data += "<td>" + user.color + "</td>";
    data += "<td>" + user.price + "</td>";
    data += `<td data-id='${user.id}'><button type ='button' class ='btn' id ='edit'>Edit</button></td>`;
    data += `<td data-id='${user.id}'><button type ='button' class ='btn' id ='delete'>Delete</button></td>`;
    data += "</tr>";
  });
  content.innerHTML = data;
  content.addEventListener("click", (e) => {
    e.preventDefault();
    let deleteId = e.target.id == "delete";
    let updatedId = e.target.id == "edit";
    let id = e.target.parentElement.dataset.id;
    if (deleteId) {
      deleteProduct(id);
    } else if (updatedId) {
      const updateValues = response.findIndex((value) => value.id == id);
      console.log(response[updateValues]);
      document.getElementById("name").value = response[updateValues].name;
      document.getElementById("color").value = response[updateValues].color;
      document.getElementById("price").value = response[updateValues].price;
      document.getElementById("head").innerHTML = "Update Product";
      document.getElementById("submit").innerHTML = "Update";
      popup.classList.add("open-popup");
      updateId = id;
    }
  });
}

function postUpdate() {
  var action = document.getElementById("submit");
  if (action.textContent === "Update") {
    updateProduct(updateId);
  }
  if (action.textContent === "submit") {
    post();
  }
}

async function post() {
  let storeData = getProductData();
  await fetch("http://localhost:8080/add", {
    method: "POST",
    headers: {
      "content-Type": "application/json",
    },
    body: JSON.stringify(storeData),
  });
  clearProductData();
  get();
}

function deleteProduct(id) {
  const reqObj = {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  };
  fetch("http://localhost:8080/delete/" + id, reqObj);
  location.reload();
}

async function updateProduct(id) {
  let storeData = getProductData(); 
  await fetch("http://localhost:8080/update/" + id, {
    method: "PUT",
    headers: {
      "content-Type": "application/json",
    },
    body: JSON.stringify(storeData),
  });
  clearProductData();
  get();
}

function getProductData() {
  return {
    name: document.getElementById("name").value,
    color: document.getElementById("color").value,
    price: document.getElementById("price").value,
  };
}

function clearProductData() {
  document.getElementById("name").value = "";
  document.getElementById("color").value = "";
  document.getElementById("price").value = "";
}

let popup = document.getElementById("popup");

function openPopup() {
  console.log("open");
  popup.classList.add("open-popup");
}

function closePopup() {
  console.log("close");
  popup.classList.remove("open-popup");
  clearProductData();
}
