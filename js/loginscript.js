const wrapper = document.querySelector('.wrapper');
const loginLink = document.querySelector('.login-link');
const registerLink = document.querySelector('.register-link');
const nextLink = document.querySelector('.next-link');
const loginForm = document.querySelector('.form-box.login');
const registerForm = document.querySelector('.form-box.register');
const nextForm = document.querySelector('.form-box.next');

loginLink.addEventListener('click', () => {
    loginForm.classList.add('active');
    registerForm.classList.remove('active');
    nextForm.classList.remove('active');
});

registerLink.addEventListener('click', () => {
    loginForm.classList.remove('active');
    registerForm.classList.add('active');
    nextForm.classList.remove('active');
});

nextLink.addEventListener('click', () => {
    loginForm.classList.remove('active');
    registerForm.classList.remove('active');
    nextForm.classList.add('active');
});

function myFunction() {
  document.getElementById("login").style.display = "none";
}

function myFunctionII() {
  document.getElementById("login").style.display = "block";
}

function checkUser() {
  var userTypeSelect = document.getElementById("user-type");
  var serviceTypeDiv = document.getElementById("service-type");

  if (userTypeSelect.value === "service-provider") {
    serviceTypeDiv.style.display = "block";
    
  } else {
    serviceTypeDiv.style.display = "none";
    
  }
}

