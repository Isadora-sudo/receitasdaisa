<script>
        const nomeField = document.getElementById('nome');
        const nomeError = document.getElementById('nome-error');

        const emailField = document.getElementById('email');
        const emailError = document.getElementById('email-error');

        const telefoneField = document.getElementById('telefone');
        const telefoneError = document.getElementById('telefone-error');

        const mensagemField = document.getElementById('mensagem');
        const mensagemError = document.getElementById('mensagem-error');

        const form = document.querySelector('.formulario-contato');

        function validateNotEmpty(field, errorElement, fieldName) {
            if (field.value.trim() === '') {
                errorElement.textContent = `Por favor, preencha o campo ${fieldName}.`;
                field.classList.add('error');
                return false;
            } else {
                errorElement.textContent = '';
                field.classList.remove('error');
                return true;
            }
        }

        nomeField.addEventListener('blur', () => {
            validateNotEmpty(nomeField, nomeError, 'Nome');
        });

        telefoneField.addEventListener('blur', () => {
            validateNotEmpty(telefoneField, telefoneError, 'Telefone');
        });

        mensagemField.addEventListener('blur', () => {
            validateNotEmpty(mensagemField, mensagemError, 'Mensagem');
        });

        emailField.addEventListener('blur', () => {
            const email = emailField.value;
            const emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w{2,}$/;

            if (email.trim() === '') {
                emailError.textContent = 'Por favor, preencha o campo Email.';
                emailField.classList.add('error');
            } else if (!emailRegex.test(email)) {
                emailError.textContent = 'Por favor, insira um e-mail válido.';
                emailField.classList.add('error');
            } else {
                emailError.textContent = '';
                emailField.classList.remove('error');
            }
        });

        form.addEventListener('submit', function(event) {
            event.preventDefault();

            const nomeValid = validateNotEmpty(nomeField, nomeError, 'Nome');
            const telefoneValid = validateNotEmpty(telefoneField, telefoneError, 'Telefone');
            const mensagemValid = validateNotEmpty(mensagemField, mensagemError, 'Mensagem');

            const email = emailField.value;
            const emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w{2,}$/;

            let emailValid = true;
            if (email.trim() === '') {
                emailError.textContent = 'Por favor, preencha o campo Email.';
                emailField.classList.add('error');
                emailValid = false;
            } else if (!emailRegex.test(email)) {
                emailError.textContent = 'Por favor, insira um e-mail válido.';
                emailField.classList.add('error');
                emailValid = false;
            } else {
                emailError.textContent = '';
                emailField.classList.remove('error');
            }

            if (nomeValid && telefoneValid && mensagemValid && emailValid) {
                alert('Mensagem enviada com sucesso!');
                form.reset();
            }
        });
    </script>
</body>
</html>

