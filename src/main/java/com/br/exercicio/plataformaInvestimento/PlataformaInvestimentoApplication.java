package com.br.exercicio.plataformaInvestimento;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.exercicio.plataformaInvestimento.services.DadosCadastroServices;
import com.br.exercicio.plataformaInvestimento.services.Exceptions;
import com.br.exercicio.plataformaInvestimento.services.InvestidoresServices;
import com.br.exercicio.plataformaInvestimento.services.ManifestacaoServices;
import com.br.exercicio.plataformaInvestimento.services.MoedasServices;

/*
 * Esse software é um sofrtware de investimento em uma plataforma utilizando springboot, o admin consegue cadastrar uma moeda acrescentando os valores a ela
 * e também consegue ter acesso ao sistema de ouvidoria, podendo responder os chamados removendo de um banco de dados e adicionando a uma tabela
 * já  feito para os modelos, o software conta com inúmeras possibilidades e também podendo ser modificado para diversos usos. O usuário tem acesso ao sistema
 * de investimento e pode depositar, sacar e investir em determinada moeda, além de poder cadastrar manifestações.
 */
@SpringBootApplication
public class PlataformaInvestimentoApplication implements CommandLineRunner {

	@Autowired
	DadosCadastroServices DCServices;

	@Autowired
	MoedasServices MServices;

	@Autowired
	InvestidoresServices IServices;

	@Autowired
	ManifestacaoServices ManifServices;

	public static void main(String[] args) {
		SpringApplication.run(PlataformaInvestimentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		Exceptions entrada = new Exceptions();

		int entrarWhile1 = 0;
		while (entrarWhile1 != 3) {
			System.out.println("[1] - Cadastro \n[2] - Login \n[3] - Sair \nDigite: ");
			int primeiroIF = entrada.readWhole();

			if (primeiroIF == 1) {
				// cadastro

				System.out.println("[1] - Usuário \n[2] - Admin \nDigite: ");
				int digiteCadastro = entrada.readWhole();

				if (digiteCadastro == 1) {
					// cadastrar usuário

					System.out.println("Nome: ");
					String nome = entrada.read();
					System.out.println("Email: ");
					String email = entrada.read();
					System.out.println("CPF: ");
					Long cpf = entrada.readLong();
					System.out.println("Número 1: ");
					Long numero1 = entrada.readLong();
					System.out.println("Número 2: ");
					Long numero2 = entrada.readLong();
					System.out.println("Usuário: ");
					entrada.read();
					String usuario = entrada.read();
					System.out.println("Senha: ");
					String senha = entrada.read();

					DCServices.cadastroUsuario(nome, email, cpf, numero1, numero2, usuario, senha);

					System.out.println("Usuário cadastrado com sucesso");

				} else if (digiteCadastro == 2) {
					// cadastrar admin

					System.out.println("Nome: ");
					String nome = entrada.read();
					System.out.println("Email: ");
					String email = entrada.read();
					System.out.println("CPF: ");
					Long cpf = entrada.readLong();
					System.out.println("Número 1: ");
					Long numero1 = entrada.readLong();
					System.out.println("Número 2: ");
					Long numero2 = entrada.readLong();
					System.out.println("Usuário: ");
					entrada.read();
					String usuario = entrada.read();
					System.out.println("Senha: ");
					String senha = entrada.read();

					DCServices.cadastroAdmin(nome, email, cpf, numero1, numero2, usuario, senha);

					System.out.println("Admin cadastrado com sucesso");
				} else {
					System.out.println("Número inexistente");
				}
			} else if (primeiroIF == 2) {
				// login

				System.out.println("Logar \n\n[1] - Usuário \n[2] - Admin \nDigite: ");
				int entrarIF2 = entrada.readWhole();

				if (entrarIF2 == 1) {
					// logar usuário

					System.out.println("Usuário: ");
					String usuario = entrada.read();
					System.out.println("Senha: ");
					String senha = entrada.read();

					DCServices.loginUsuario(usuario, senha);

					if (DCServices.loginUsuario(usuario, senha) != null) {
						System.out.println("Login Usuário efetuado com sucesso");

						int entrarWhile6 = 0;
						while (entrarWhile6 != 4) {

							int entrarWhile7 = 0;
							while (entrarWhile7 != 6) {
								System.out.println(
										"[1] - Investir \n[2] - Ouvidoria \n[3] - Depósito \n[4] - Saque \n[5] - Sair \nDigite: ");
								int digite9 = entrada.readWhole();

								if (digite9 == 1) {
									// investir

									System.out.println("As moedas são: ");

									MServices.listarMoedass();

									System.out.println("Preencha o campo com a moeda que deseja investir");

									System.out.println("Nome: ");
									String nomeMoeda = entrada.read();
									System.out.println("Valor: ");
									Double valorInvestir = entrada.readDouble();

									// estas funções utilizam para investimento na moeda, verificam a moeda e investem os valores
									if (IServices.investirMoeda(DCServices.loginUsuario(usuario, senha), nomeMoeda,
											entrarWhile1) != null) {
										System.out.println("Moeda encontrada, seu investimento será aplicado logo");
										if (DCServices.verificarSaldo(DCServices.loginUsuario(usuario, senha),
												valorInvestir) != null) {
											DCServices.sacar(DCServices.loginUsuario(usuario, senha), valorInvestir);
											IServices.adicionarInvestimento(DCServices.loginUsuario(usuario, senha),
													nomeMoeda, valorInvestir);
											System.out.println("Valor removido da sua conta");
										} else {
											System.out.println("Saldo insuficiente");
										}
									} else {
										System.out.println(
												"Moeda não encontrada, verifique as moedas cadastradas no sistema");
									}

									IServices.investirMoeda(DCServices.loginUsuario(usuario, senha), nomeMoeda,
											valorInvestir);

								} else if (digite9 == 2) {
									// ouvidoria

									System.out.println("Setor de ouvidoria");

									int entrarWhile10 = 0;
									while (entrarWhile10 != 2) {
										System.out.println("[1] - Cadastrar manifestacao \n[2] - Voltar \nDigite: ");
										int d10 = entrada.readWhole();

										if (d10 == 1) {
											// cadastrar manifestação

											System.out.println(
													"[1] - Reclamação \n[2] - Elogio \n[3] - Sugestão \nDigite: ");
											int d11 = entrada.readWhole();

											if (d11 == 1) {
												// reclamação

												String tipo = "Reclamacao";
												System.out.println("Tipo: " + tipo);
												System.out.println("Texto: ");
												String texto = entrada.read();

												ManifServices.adicionarManifestacao(
														DCServices.loginUsuario(usuario, senha), tipo, texto);
												ManifServices.adicionarManifestacaoAtendida(
														DCServices.loginUsuario(usuario, senha), tipo, texto, null);

											} else if (d11 == 2) {
												// elogio

												String tipo = "Elogio";
												System.out.println("Tipo: " + tipo);
												System.out.println("Texto: ");
												String texto = entrada.read();

												ManifServices.adicionarManifestacao(
														DCServices.loginUsuario(usuario, senha), tipo, texto);
												ManifServices.adicionarManifestacaoAtendida(
														DCServices.loginUsuario(usuario, senha), tipo, texto, null);

											} else if (d11 == 3) {
												// sugestão

												String tipo = "Sugestao";
												System.out.println("Tipo: " + tipo);
												System.out.println("Texto: ");
												String texto = entrada.read();

												ManifServices.adicionarManifestacao(
														DCServices.loginUsuario(usuario, senha), tipo, texto);
												ManifServices.adicionarManifestacaoAtendida(
														DCServices.loginUsuario(usuario, senha), tipo, texto, null);

											} else {
												System.out.println("Número inexistente");
											}
										} else if (d10 == 2) {
											System.out.println("Voltando");
											break;
										} else {
											System.out.println("Número inexistente");
										}
									}
								} else if (digite9 == 3) {
									// Depósito
									System.out.println("Selecione o valor que deseja depositar");
									System.out.println("Valor: ");
									Double saldo = entrada.readDouble();

									DCServices.adicionarSaldo(DCServices.loginUsuario(usuario, senha), saldo);
								} else if (digite9 == 4) {
									// saque

									System.out.println("Valor: ");
									Double valor = entrada.readDouble();

									DCServices.sacar(DCServices.loginUsuario(usuario, senha), valor);

									System.out.println("Saldo removido com sucesso");

								} else if (digite9 == 5) {
									// voltar
									System.out.println("Voltando");
									break;
								} else {
									System.out.println("Número inexistente!");
								}
							}
							break;
						}
					} else {
						System.out.println("Usuário ou senha incorretos");
					}
				} else if (entrarIF2 == 2) {
					// logar admin

					System.out.println("Usuário: ");
					String usuario = entrada.read();
					System.out.println("Senha: ");
					String senha = entrada.read();

					DCServices.loginAdmin(usuario, senha);

					if (DCServices.loginAdmin(usuario, senha) != null) {
						System.out.println("Login Admin efetuado com sucesso");

						int entrarWhile7 = 0;
						while (entrarWhile7 != 6) {
							System.out.println(
									"[1] - Cadastrar moeda no sistema \n[2] - Atualizar moeda \n[3] - Listar moedas \n[4] - Remover Moeda \n[5] - Ouvidoria \n[6] - Sair \nDigite: ");
							int digite9 = entrada.readWhole();

							if (digite9 == 1) {
								// cadastrar moeda
								System.out.println("Nacionalidade: ");
								String nacionalidade = entrada.read();
								System.out.println("Nome");
								String nomeMoeda = entrada.read();
								System.out.println("Sigla: ");
								String sigla = entrada.read();
								System.out.println("Valor: ");
								Double valorCotacao = entrada.readDouble();
								System.out.println("Tipo: ");
								String tipo = entrada.read();

								MServices.adicionarMoeda(nacionalidade, nomeMoeda, sigla, valorCotacao, tipo);

								System.out.println("Nova moeda adicionada por sucesso");
							} else if (digite9 == 2) {
								// atualizar cota moeda
								System.out.println("Listando as moedas");

								MServices.listarMoedass();

								System.out.println("Digite o id de qual moeda deseja atualizar os dados \nDigite: ");
								int id = entrada.readWhole();
								System.out.println("Valor: ");
								Double novoValor = entrada.readDouble();
								MServices.atualizarValorMoeda(id, novoValor);

								System.out.println("Valor da moeda atualizada com sucesso");
							} else if (digite9 == 3) {
								// listar todas as moedas
								System.out.println("Listando");

								MServices.listarMoedass();
							} else if (digite9 == 4) {
								System.out.println("Listando moedas");

								MServices.listarMoedass();

								System.out.println("Digite o id da moeda que deseja remover \nDigite: ");
								int id = entrada.readWhole();

								MServices.removerMoeda(id);
							} else if (digite9 == 5) {
								// ouvidoria

								int entrarWhile11 = 0;
								while (entrarWhile11 != 3) {
									System.out.println(
											"[1] - Listar manifestação \n[2] - Responder manifestação \n[3] - Voltar \nDigite: ");
									int entrarIF10 = entrada.readWhole();

									if (entrarIF10 == 1) {
										// listar manifestação
										System.out.println("Listando manifestações");
										ManifServices.listarManifestacao();
									} else if (entrarIF10 == 2) {
										// responder manifestação
										ManifServices.listarManifestacao();
										
										System.out.println("Id: ");
										long id = entrada.readLong();
										
										System.out.println("Responder manifestação: ");
										String resposta = input.nextLine();
										
										ManifServices.atualizarMAnifestacao(id, resposta);
										
										ManifServices.removerManifestacao(id);
										
									} else if (entrarIF10 == 3) {
										// voltando
										System.out.println("Voltando");
										break;
									} else {
										System.out.println("Número inexistente");
									}

								}
							} else if (digite9 == 6) {
								// voltando
								System.out.println("Voltando");
								break;
							} else {
								System.out.println("Número inexistente");
							}
						}
					} else {
						System.out.println("Usuário ou senha incorretos");
					}
				} else {
					System.out.println("Número inexistente");
				}
			} else if (primeiroIF == 3) {
				System.out.println("Saindo");
				break;
			} else {
				System.out.println("Número inexistente");
				break;
			}
		}
		input.close();
	}
}
