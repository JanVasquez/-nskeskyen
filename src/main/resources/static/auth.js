function login() {
    localStorage.setItem("loggedIn", true);
    window.location.href = "/app";
}

function register() {
    localStorage.setItem("loggedIn", true);
    window.location.href = "/app";
}

function logout() {
    localStorage.removeItem("loggedIn");
    window.location.href = "/";
}