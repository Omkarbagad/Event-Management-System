const apiUrl = "http://localhost:8080/api/users";
let sortOrder = 1;
let studentData = [];

const inputName = document.getElementById("name");
const inputPassword = document.getElementById("password");
const inputEmail = document.getElementById("email");
const inputNumber = document.getElementById("number");
const inputType = document.getElementById("usertype");
const form = document.getElementById("submitData");
const submitBtn = form.querySelector("button");


submitBtn.disabled = true;
function updateSubmitStatus() {
    const nameValid = inputName.value.trim() !== "";
    const emailValid = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(inputEmail.value.trim());
    const passwordValid = /^(?=.*\d)(?=.*[#$@!%&*?])[A-Za-z\d#$@!%&*?]{8,}$/.test(inputPassword.value.trim());
    const numberValid = inputNumber.value.trim() !== "";
    const typeValid = inputType.value !== "";
    submitBtn.disabled = !(nameValid && emailValid && passwordValid && numberValid && typeValid);
  }

  [inputName, inputEmail, inputPassword, inputNumber, inputType].forEach(input => {
    input.addEventListener("input", updateSubmitStatus);
  });

//add

form.addEventListener("submit", function (e) {
    e.preventDefault();

    const student = {
        name: inputName.value.trim(),
        email: inputEmail.value.trim(),
        password: inputPassword.value.trim(),
        number: inputNumber.value.trim(),
        usertype: inputType.value
    };

    fetch(apiUrl)
            .then(res => res.json())
            .then(data => {
                const isEmailExists = data.find(s => s.email.toLowerCase() === student.email.toLowerCase());
                if (isEmailExists) {
                    alert("Email Already Exist");
                    inputEmail.classList.add("is-invalid");
                } else {
                    fetch(apiUrl, {
                        method: "POST",
                        headers: { "Content-Type": "application/json" },
                        body: JSON.stringify(student)
                    }).then(() => {
                        form.reset();
                        window.location.href = "LoginForm.html";
                        clearValidation();
                    });
                }
            });
    }
)

//validation
inputName.addEventListener("blur", () => {
    if (inputName.value.trim().length != "") {
        inputName.classList.remove("is-invalid");
        inputName.classList.add("is-valid");
    } else {
        inputName.classList.add("is-invalid");
        inputName.classList.remove("is-valid");
    }
});
//email
inputEmail.addEventListener("blur", () => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (emailRegex.test(inputEmail.value.trim())) {
        inputEmail.classList.remove("is-invalid");
        inputEmail.classList.add("is-valid");
    } else {
        inputEmail.classList.add("is-invalid");
        inputEmail.classList.remove("is-valid");
    }
});
//password
inputPassword.addEventListener("blur", () => {
    const passwordRegex = /^(?=.*\d)(?=.*[#$@!%&*?])[A-Za-z\d#$@!%&*?]{8,}$/;
    if (passwordRegex.test(inputPassword.value.trim())) {
        inputPassword.classList.remove("is-invalid");
        inputPassword.classList.add("is-valid");
    } else {
        inputPassword.classList.add("is-invalid");
        inputPassword.classList.remove("is-valid");
    }
});
//number
inputNumber.addEventListener("blur", () => {
    if (inputNumber.value.trim().length != "") {
        inputNumber.classList.remove("is-invalid");
        inputNumber.classList.add("is-valid");
    } else {
        inputNumber.classList.add("is-invalid");
        inputNumber.classList.remove("is-valid");
    }
});

//select type
inputType.addEventListener("blur", () => {
    if (inputType.value !== "") {
        inputType.classList.remove("is-invalid");
        inputType.classList.add("is-valid");
    } else {
        inputType.classList.add("is-invalid");
        inputType.classList.remove("is-valid");
    }
});

