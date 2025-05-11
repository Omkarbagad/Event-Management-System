
// function decodeJWT(token) {
//     if (!token) return null;

//     const parts = token.split('.');
//     if (parts.length !== 3) return null; const payload = parts[1];
//     // Base64URL decode
//     const decodedPayload = atob(payload.replace(/-/g, '+').replace(/_/g, '/'));

//     try {
//         return JSON.parse(decodedPayload);
//     } catch (e) {
//         console.error("Invalid JWT payload:", e); return null;
//     }
// }



















// function decodeJWT(token) {
//     if (!token) return null;

//     const parts = token.split('.');
//     if (parts.length !== 3) return null;

//     let payload = parts[1];
//     // Replace base64url characters
//     payload = payload.replace(/-/g, '+').replace(/_/g, '/');

//     // Add padding if necessary
//     while (payload.length % 4 !== 0) {
//         payload += '=';
//     }

//     try {
//         const decodedPayload = atob(payload);
//         return JSON.parse(decodedPayload);
//     } catch (e) {
//         console.error("Invalid JWT payload:", e);
//         return null;
//     }
// }










function decodeJWT(token) {
    if (!token) {
        console.error("No token provided");
        return null;
    }

    console.log("Attempting to decode token:", token);
    
    const parts = token.split('.');
    if (parts.length !== 3) {
        console.error("Invalid token format: expected 3 parts, got", parts.length);
        return null;
    }

    let payload = parts[1];
    console.log("Raw payload:", payload);
    
    // Replace base64url characters
    payload = payload.replace(/-/g, '+').replace(/_/g, '/');
    console.log("Replaced payload:", payload);

    // Add padding if necessary
    while (payload.length % 4 !== 0) {
        payload += '=';
    }
    console.log("Padded payload:", payload);

    try {
        const decodedPayload = atob(payload);
        console.log("Decoded payload:", decodedPayload);
        const parsedPayload = JSON.parse(decodedPayload);
        console.log("Parsed payload:", parsedPayload);
        return parsedPayload;
    } catch (e) {
        console.error("Error decoding JWT:", e);
        console.error("Token parts:", parts);
        return null;
    }
}
function getUserId() {
    const token = localStorage.getItem("token");
    if (!token)
        window.location.href = "login.html";
    const decoded = decodeJWT(token);
    return decoded.userid;
}

function getUserName() {
    const token = localStorage.getItem("token");
    if (!token)
        window.location.href = "login.html";
    const decoded = decodeJWT(token);
    return decoded.sub;
}

function getUserEmail() {
    const token = localStorage.getItem("token");
    if (!token)
        window.location.href = "login.html";;
    const decoded = decodeJWT(token);
    return decoded.email;
}

function getUserType() {
    const token = localStorage.getItem("token");
    if (!token)
        window.location.href = "login.html";
    const decoded = decodeJWT(token);
    return decoded.usertype;
}

function getAuthorization() {
    const token = localStorage.getItem("token");
    if (!token)
        window.location.href = "LoginForm.html";
    const decoded = decodeJWT(token);
    return `Bearer ${token}`;
}

function logout() {
    localStorage.removeItem("token");
    localStorage.clear();
    window.location.href = "login.html";
}
