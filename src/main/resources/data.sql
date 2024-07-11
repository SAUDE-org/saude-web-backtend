INSERT INTO public.profissional(
	id_profissional, cpf, email, endereco, especialidade, nome, registro_pro, telefone)
	VALUES (1, "99999999999", "ana@gmail.com", "R. Alta, 45, Alecrim, Natal, RN", "Nutricionista", "Ana Maria Braga", "CRN6-99990", "(84)99999-8888");

INSERT INTO public.paciente(
	id_paciente, cpf, email, endereco, nome, telefone)
	VALUES (1, "88888888888", "joao@email.com", "R. Pe Anchieta, Capim Macio, Natal, RN", "João Maria de José", "(84)88888-7777");

INSERT INTO public.clinica(
	id_clinica, cnpj, email, endereco, nome, telefone)
	VALUES (1, "99999999000199", "hospital@email.com", "Av. Ayrton Senna, 34 - Capim Macio", "Hospital Ponta Negra", "(84)77777-6666");

INSERT INTO public.consulta(
	id_consulta, data, horario, clinica_id, paciente_id, profissional_id)
	VALUES ('1', "22/08/2024", "11:30", 1, 1, 1);

