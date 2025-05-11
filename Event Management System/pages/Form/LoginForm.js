

  document.getElementById("loginForm").addEventListener("submit", function (e) {
    e.preventDefault();
    verify(); 
  });
  
  function verify() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
  
    fetch("http://localhost:8080/api/users")
      .then(res => res.json())
      .then(users => {
        console.log("Fetched users:", users);
        const user = users.find(u => u.email === email && u.password === password);
        console.log("Matched user:", user);

        if (user) {
          if (user.usertype === "user") { 
            localStorage.setItem("user", JSON.stringify(user));
            window.location.href = `/pages/user/userLayout.html?userId=${user.id}`;
          } else if (user.usertype === "organizer") {
            if (!user.id) { 
              console.error("User object has no 'id' field:", user);
              return;
            }
            localStorage.setItem("organizerLoggedIn", "true");
            localStorage.setItem("organizerId", user.id);
            localStorage.setItem("user", JSON.stringify(user));
            window.location.href = `/pages/organizer/organizerLayout.html?userId=${user.id}`;
          }
        } else {
          document.getElementById("error").textContent = "Invalid email or password.";
        }
      })
      .catch(err => {
        console.error("Error fetching users:", err);
      });
  }
  function getUserId() {
    const user = JSON.parse(localStorage.getItem("user"));
    return user ? user.id : null;
  }
  
  function getUserName() {
    const user = JSON.parse(localStorage.getItem("user"));
    return user ? user.name : null;
  }
  
  function getUserType() {
    const user = JSON.parse(localStorage.getItem("user"));
    return user ? user.usertype : null;
  }
  
  function logout() {
    localStorage.clear();
    localStorage.setItem("loggedOut", "true");
    window.location.href = "login.html";
  }





// document.getElementById("loginForm").addEventListener("submit", function (e) {
//   e.preventDefault();
//   verify();
// });

// function verify() {
//   const email = document.getElementById("email").value;
//   const password = document.getElementById("password").value;

//   fetch("http://localhost:8080/auth/signin", {
//     method: "POST",
//     headers: {
//       "Content-Type": "application/json"  // ✅ Only content-type needed for login
//     },
//     body: JSON.stringify({ email, password }),
//   })
//     .then(response => {
//       if (!response.ok) {
//         if (response.status === 401) {
//           throw new Error("Unauthorized - Invalid email or password.");
//         } else if (response.status === 404) {
//           throw new Error("User not found.");
//         } else {
//           throw new Error(`Error: ${response.status}`);
//         }
//       }
//       return response.json();
//     })
// .then(data => {
//   const token = data.token;
//   if (!token) throw new Error("Token not received.");

//   localStorage.setItem("token", token);

//   const decoded = decodeJWT(token); // use your existing function

//   if (!decoded || !decoded.usertype || !decoded.userid) {
//     throw new Error("Missing user data in token.");
//   }

//   // Redirect based on user type
//   if (decoded.usertype === "organizer") {
//         // ✅ Save values to localStorage
//     localStorage.setItem("organizerId", decoded.userid);
//     localStorage.setItem("organizerLoggedIn", "true");
//         console.log("Raw token received:", token);
//     console.log("Token length:", token.length);
//     console.log("Token with brackets to check whitespace: [" + token + "]");
//     window.location.href = `/pages/organizer/organizerLayout.html?organizerId=${decoded.userid}`;
//   } else if (decoded.usertype === "user") {
//     window.location.href = `userLayout.html?userId=${decoded.userid}`;
//   } else {
//     throw new Error("Unknown user type.");
//   }
// })

//     .catch(error => {
//       console.error(error);
//       document.getElementById("error").textContent = error.message || "Login failed. Try again.";
//     });
// }

// function getUserId() {
//   const user = JSON.parse(localStorage.getItem("user"));
//   return user ? user.id : null;
// }

// function getUserName() {
//   const user = JSON.parse(localStorage.getItem("user"));
//   return user ? user.name : null;
// }

// function getUsertype() {
//   const user = JSON.parse(localStorage.getItem("user"));
//   return user ? user.usertype : null;
// }

// function logout() {
//   localStorage.clear();
//   localStorage.setItem("loggedOut", "true");
//   window.location.href = "/pages/Form/LoginForm.html";
// }
