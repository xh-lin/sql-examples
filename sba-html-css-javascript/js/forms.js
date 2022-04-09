
const registerForm = $('#registerForm');
const emailInput = registerForm.find("input[name='email']");
const passwordInput = registerForm.find("input[name='password']");
const passwordInput2 = registerForm.find("input[name='password2']");
const userTypeInput = registerForm.find("#userType");

const userPwMap = new Map();

registerForm.find('button:submit').click(function(event) {
    for (const input of registerForm.find('input, select')) {
        if ($(input).val() === ''
                || ($(input).is('select') && $(input).val() === null)
                || ($(input).attr('type') === 'checkbox' && $(input).prop('checked') === false)) {
            $(input).addClass('is-invalid');
        } else {
            $(input).removeClass('is-invalid');
        }
    }
});

registerForm.submit(function(event) {
    event.preventDefault();

    if (userPwMap.has(emailInput.val())) {
        alert('Email has already been taken.');
    } else if (passwordInput.val() !== passwordInput2.val()) {
        alert('Comfirm password doesn\'t match.');
    } else {
        userPwMap.set(emailInput.val(), [passwordInput.val(), userTypeInput.val()]);
        $('#userTableBody').append(`
            <tr>
                <td>${emailInput.val()}</td>
                <td>${passwordInput.val()}</td>
                <td>${userTypeInput.val()}</td>
            </tr>
        `);
        $(this)[0].reset();
        console.log(userPwMap);
    }
});

$('#loginForm').submit(function(event) {
    event.preventDefault();

    const email = $(this).find("input[name='email']").val();
    const password = $(this).find("input[name='password']").val();

    if (userPwMap.has(email)) {
        if (userPwMap.get(email)[0] === password) {
            $('#loginMessage').html(`<div class="alert alert-success">Hello ${email}</div>`);
            $(this)[0].reset();
        } else {
            alert('Invalid password.');
        }
    } else {
        alert(`User with email ${email} not found.`);
    }
});

passwordInput.on('input', function() {
    const password = $(this).val();
    validatePassword(password)
});

const validations = [
    {id: 'pwUpper', regex: /^.*[A-Z].*$/},
    {id: 'pwLower', regex: /^.*[a-z].*$/},
    {id: 'pwDigit', regex: /^.*\d.*$/},
    {id: 'pwSpeChar', regex: /^.*[^\w\s].*$/},
    {id: 'pwMinLen', regex: /^.{8,}$/},
];

function validatePassword(password) {
    let isValid = true;
    for (const validation of validations) {
        let validationText = $(`#passwordHelpBlock #${validation.id}`);
        if (validation.regex.test(password)) {
            validationText.removeClass('text-danger');
        } else {
            validationText.addClass('text-danger');
            isValid = false;
        }
    }

    if (isValid) {
        passwordInput.removeClass('is-invalid');
    } else {
        passwordInput.addClass('is-invalid');
    }
}

passwordInput2.on('input', function() {
    if ($(this).val() === passwordInput.val()) {
        $(this).removeClass('is-invalid');
    } else {
        $(this).addClass('is-invalid');
    }
});