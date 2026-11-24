// Gerado a partir dos DTOs do backend
export const RECURSOS = [
 {
  "id": "alunos",
  "titulo": "Aluno",
  "caminho": "/alunos",
  "editar": true,
  "campos": [
   {
    "nome": "nome",
    "rotulo": "Nome",
    "tipo": "text"
   },
   {
    "nome": "cpf",
    "rotulo": "Cpf",
    "tipo": "text"
   },
   {
    "nome": "email",
    "rotulo": "Email",
    "tipo": "text"
   },
   {
    "nome": "matricula",
    "rotulo": "Matricula",
    "tipo": "text"
   }
  ]
 },
 {
  "id": "areas-tecnologicas",
  "titulo": "Area tecnologica",
  "caminho": "/areas-tecnologicas",
  "editar": true,
  "campos": [
   {
    "nome": "eixoTecnologicoId",
    "rotulo": "Eixo tecnologico",
    "tipo": "ref",
    "ref": "/eixos-tecnologicos"
   },
   {
    "nome": "nome",
    "rotulo": "Nome",
    "tipo": "text"
   }
  ]
 },
 {
  "id": "capacidades",
  "titulo": "Capacidade",
  "caminho": "/capacidades",
  "editar": true,
  "campos": [
   {
    "nome": "unidadeCurricularId",
    "rotulo": "Unidade curricular",
    "tipo": "ref",
    "ref": "/unidades-curriculares"
   },
   {
    "nome": "tipo",
    "rotulo": "Tipo",
    "tipo": "select",
    "opcoes": [
     "BASICA",
     "TECNICA",
     "SOCIOEMOCIONAL"
    ]
   },
   {
    "nome": "dominio",
    "rotulo": "Dominio",
    "tipo": "select",
    "opcoes": [
     "COGNITIVO",
     "PSICOMOTOR",
     "AFETIVO"
    ]
   },
   {
    "nome": "descricao",
    "rotulo": "Descricao",
    "tipo": "textarea"
   },
   {
    "nome": "padraoDesempenhoIds",
    "rotulo": "Padrao desempenho",
    "tipo": "multi",
    "ref": "/padroes-desempenho"
   }
  ]
 },
 {
  "id": "conhecimentos",
  "titulo": "Conhecimento",
  "caminho": "/conhecimentos",
  "editar": true,
  "campos": [
   {
    "nome": "unidadeCurricularId",
    "rotulo": "Unidade curricular",
    "tipo": "ref",
    "ref": "/unidades-curriculares"
   },
   {
    "nome": "topico",
    "rotulo": "Topico",
    "tipo": "text"
   },
   {
    "nome": "detalhamento",
    "rotulo": "Detalhamento",
    "tipo": "textarea"
   }
  ]
 },
 {
  "id": "cursos",
  "titulo": "Curso",
  "caminho": "/cursos",
  "editar": true,
  "campos": [
   {
    "nome": "areaTecnologicaId",
    "rotulo": "Area tecnologica",
    "tipo": "ref",
    "ref": "/areas-tecnologicas"
   },
   {
    "nome": "nome",
    "rotulo": "Nome",
    "tipo": "text"
   },
   {
    "nome": "tipoCurso",
    "rotulo": "Tipo curso",
    "tipo": "select",
    "opcoes": [
     "INICIACAO_PROFISSIONAL",
     "QUALIFICACAO_PROFISSIONAL",
     "APRENDIZAGEM_INDUSTRIAL",
     "APERFEICOAMENTO",
     "TECNICO",
     "ESPECIALIZACAO_TECNICA",
     "GRADUACAO_TECNOLOGICA",
     "POS_GRADUACAO"
    ]
   },
   {
    "nome": "ativo",
    "rotulo": "Ativo",
    "tipo": "checkbox"
   }
  ]
 },
 {
  "id": "eixos-tecnologicos",
  "titulo": "Eixo tecnologico",
  "caminho": "/eixos-tecnologicos",
  "editar": true,
  "campos": [
   {
    "nome": "nome",
    "rotulo": "Nome",
    "tipo": "text"
   }
  ]
 },
 {
  "id": "escolas",
  "titulo": "Escola",
  "caminho": "/escolas",
  "editar": true,
  "campos": [
   {
    "nome": "nome",
    "rotulo": "Nome",
    "tipo": "text"
   },
   {
    "nome": "codigoUnidade",
    "rotulo": "Codigo unidade",
    "tipo": "text"
   },
   {
    "nome": "cidade",
    "rotulo": "Cidade",
    "tipo": "text"
   },
   {
    "nome": "estado",
    "rotulo": "Estado",
    "tipo": "text"
   },
   {
    "nome": "ativo",
    "rotulo": "Ativo",
    "tipo": "checkbox"
   }
  ]
 },
 {
  "id": "funcoes",
  "titulo": "Funcao",
  "caminho": "/funcoes",
  "editar": true,
  "campos": [
   {
    "nome": "planoCursoId",
    "rotulo": "Plano curso",
    "tipo": "ref",
    "ref": "/planos-curso"
   },
   {
    "nome": "numero",
    "rotulo": "Numero",
    "tipo": "number"
   },
   {
    "nome": "descricao",
    "rotulo": "Descricao",
    "tipo": "textarea"
   }
  ]
 },
 {
  "id": "modulos",
  "titulo": "Modulo",
  "caminho": "/modulos",
  "editar": true,
  "campos": [
   {
    "nome": "planoCursoId",
    "rotulo": "Plano curso",
    "tipo": "ref",
    "ref": "/planos-curso"
   },
   {
    "nome": "nome",
    "rotulo": "Nome",
    "tipo": "text"
   },
   {
    "nome": "tipoModulo",
    "rotulo": "Tipo modulo",
    "tipo": "select",
    "opcoes": [
     "BASICO",
     "INTRODUTORIO",
     "ESPECIFICO"
    ]
   },
   {
    "nome": "ordem",
    "rotulo": "Ordem",
    "tipo": "number"
   },
   {
    "nome": "cargaHoraria",
    "rotulo": "Carga horaria",
    "tipo": "number"
   }
  ]
 },
 {
  "id": "padroes-desempenho",
  "titulo": "Padrao desempenho",
  "caminho": "/padroes-desempenho",
  "editar": true,
  "campos": [
   {
    "nome": "subfuncaoId",
    "rotulo": "Subfuncao",
    "tipo": "ref",
    "ref": "/subfuncoes"
   },
   {
    "nome": "descricao",
    "rotulo": "Descricao",
    "tipo": "textarea"
   }
  ]
 },
 {
  "id": "perfis",
  "titulo": "Perfil",
  "caminho": "/perfis",
  "editar": true,
  "campos": [
   {
    "nome": "nome",
    "rotulo": "Nome",
    "tipo": "text"
   },
   {
    "nome": "descricao",
    "rotulo": "Descricao",
    "tipo": "textarea"
   }
  ]
 },
 {
  "id": "planos-curso",
  "titulo": "Plano curso",
  "caminho": "/planos-curso",
  "editar": true,
  "campos": [
   {
    "nome": "cursoId",
    "rotulo": "Curso",
    "tipo": "ref",
    "ref": "/cursos"
   },
   {
    "nome": "codigoPlano",
    "rotulo": "Codigo plano",
    "tipo": "text"
   },
   {
    "nome": "versao",
    "rotulo": "Versao",
    "tipo": "text"
   },
   {
    "nome": "cargaHorariaTotal",
    "rotulo": "Carga horaria total",
    "tipo": "number"
   },
   {
    "nome": "dataAprovacao",
    "rotulo": "Data aprovacao",
    "tipo": "date"
   },
   {
    "nome": "ativo",
    "rotulo": "Ativo",
    "tipo": "checkbox"
   }
  ]
 },
 {
  "id": "compartilhamentos",
  "titulo": "Compartilhamento",
  "caminho": "/compartilhamentos",
  "editar": false,
  "campos": [
   {
    "nome": "situacaoAprendizagemId",
    "rotulo": "Situacao aprendizagem",
    "tipo": "ref",
    "ref": "/situacoes-aprendizagem"
   },
   {
    "nome": "tipoCompartilhamento",
    "rotulo": "Tipo compartilhamento",
    "tipo": "select",
    "opcoes": [
     "GLOBAL",
     "ESCOLA",
     "CURSO",
     "USUARIO"
    ]
   },
   {
    "nome": "escolaId",
    "rotulo": "Escola",
    "tipo": "ref",
    "ref": "/escolas"
   },
   {
    "nome": "cursoId",
    "rotulo": "Curso",
    "tipo": "ref",
    "ref": "/cursos"
   },
   {
    "nome": "usuarioDestinatarioId",
    "rotulo": "Usuario destinatario",
    "tipo": "ref",
    "ref": "/usuarios"
   }
  ]
 },
 {
  "id": "criterios-avaliacao",
  "titulo": "Criterio avaliacao",
  "caminho": "/criterios-avaliacao",
  "editar": true,
  "campos": [
   {
    "nome": "instrumentoId",
    "rotulo": "Instrumento",
    "tipo": "ref",
    "ref": "/instrumentos-avaliacao"
   },
   {
    "nome": "capacidadeId",
    "rotulo": "Capacidade",
    "tipo": "ref",
    "ref": "/capacidades"
   },
   {
    "nome": "descricaoCriterio",
    "rotulo": "Descricao criterio",
    "tipo": "text"
   },
   {
    "nome": "prioridadePeso",
    "rotulo": "Prioridade peso",
    "tipo": "number"
   }
  ]
 },
 {
  "id": "criterio-rubricas",
  "titulo": "Criterio rubrica",
  "caminho": "/criterio-rubricas",
  "editar": true,
  "campos": [
   {
    "nome": "criterioId",
    "rotulo": "Criterio",
    "tipo": "ref",
    "ref": "/criterios-avaliacao"
   },
   {
    "nome": "nivel",
    "rotulo": "Nivel",
    "tipo": "number"
   },
   {
    "nome": "descricaoRubrica",
    "rotulo": "Descricao rubrica",
    "tipo": "text"
   },
   {
    "nome": "pontuacao",
    "rotulo": "Pontuacao",
    "tipo": "number"
   }
  ]
 },
 {
  "id": "estrategias-ensino",
  "titulo": "Estrategia ensino",
  "caminho": "/estrategias-ensino",
  "editar": true,
  "campos": [
   {
    "nome": "situacaoAprendizagemId",
    "rotulo": "Situacao aprendizagem",
    "tipo": "ref",
    "ref": "/situacoes-aprendizagem"
   },
   {
    "nome": "nomeEstrategia",
    "rotulo": "Nome estrategia",
    "tipo": "text"
   },
   {
    "nome": "descricaoAtividade",
    "rotulo": "Descricao atividade",
    "tipo": "text"
   }
  ]
 },
 {
  "id": "historico-pdf",
  "titulo": "Historico pdf",
  "caminho": "/historico-pdf",
  "editar": false,
  "campos": [
   {
    "nome": "situacaoAprendizagemId",
    "rotulo": "Situacao aprendizagem",
    "tipo": "ref",
    "ref": "/situacoes-aprendizagem"
   },
   {
    "nome": "versao",
    "rotulo": "Versao",
    "tipo": "text"
   },
   {
    "nome": "caminhoArquivoPdf",
    "rotulo": "Caminho arquivo pdf",
    "tipo": "text"
   },
   {
    "nome": "hashConteudo",
    "rotulo": "Hash conteudo",
    "tipo": "text"
   }
  ]
 },
 {
  "id": "instrumentos-avaliacao",
  "titulo": "Instrumento avaliacao",
  "caminho": "/instrumentos-avaliacao",
  "editar": true,
  "campos": [
   {
    "nome": "situacaoAprendizagemId",
    "rotulo": "Situacao aprendizagem",
    "tipo": "ref",
    "ref": "/situacoes-aprendizagem"
   },
   {
    "nome": "nomeInstrumento",
    "rotulo": "Nome instrumento",
    "tipo": "text"
   },
   {
    "nome": "descricao",
    "rotulo": "Descricao",
    "tipo": "textarea"
   },
   {
    "nome": "tipoMetodo",
    "rotulo": "Tipo metodo",
    "tipo": "select",
    "opcoes": [
     "GRADUAL",
     "DICOTOMICO"
    ]
   }
  ]
 },
 {
  "id": "recursos-ambientes",
  "titulo": "Recurso ambiente",
  "caminho": "/recursos-ambientes",
  "editar": true,
  "campos": [
   {
    "nome": "situacaoAprendizagemId",
    "rotulo": "Situacao aprendizagem",
    "tipo": "ref",
    "ref": "/situacoes-aprendizagem"
   },
   {
    "nome": "ambientePedagogico",
    "rotulo": "Ambiente pedagogico",
    "tipo": "text"
   },
   {
    "nome": "recursosDidaticos",
    "rotulo": "Recursos didaticos",
    "tipo": "text"
   }
  ]
 },
 {
  "id": "situacoes-aprendizagem",
  "titulo": "Situacao aprendizagem",
  "caminho": "/situacoes-aprendizagem",
  "editar": true,
  "campos": [
   {
    "nome": "titulo",
    "rotulo": "Titulo",
    "tipo": "text"
   },
   {
    "nome": "unidadeCurricularId",
    "rotulo": "Unidade curricular",
    "tipo": "ref",
    "ref": "/unidades-curriculares"
   },
   {
    "nome": "turmaId",
    "rotulo": "Turma",
    "tipo": "ref",
    "ref": "/turmas"
   },
   {
    "nome": "tipoEstrategia",
    "rotulo": "Tipo estrategia",
    "tipo": "select",
    "opcoes": [
     "SITUACAO_PROBLEMA",
     "ESTUDO_DE_CASO",
     "PROJETO",
     "PESQUISA_APLICADA"
    ]
   },
   {
    "nome": "contextualizacao",
    "rotulo": "Contextualizacao",
    "tipo": "text"
   },
   {
    "nome": "desafio",
    "rotulo": "Desafio",
    "tipo": "textarea"
   },
   {
    "nome": "resultadosEsperados",
    "rotulo": "Resultados esperados",
    "tipo": "textarea"
   },
   {
    "nome": "cargaHorariaSa",
    "rotulo": "Carga horaria sa",
    "tipo": "number"
   },
   {
    "nome": "capacidadeIds",
    "rotulo": "Capacidade",
    "tipo": "multi",
    "ref": "/capacidades"
   },
   {
    "nome": "conhecimentoIds",
    "rotulo": "Conhecimento",
    "tipo": "multi",
    "ref": "/conhecimentos"
   }
  ]
 },
 {
  "id": "subfuncoes",
  "titulo": "Subfuncao",
  "caminho": "/subfuncoes",
  "editar": true,
  "campos": [
   {
    "nome": "funcaoId",
    "rotulo": "Funcao",
    "tipo": "ref",
    "ref": "/funcoes"
   },
   {
    "nome": "codigoSubfuncao",
    "rotulo": "Codigo subfuncao",
    "tipo": "text"
   },
   {
    "nome": "descricao",
    "rotulo": "Descricao",
    "tipo": "textarea"
   }
  ]
 },
 {
  "id": "turmas",
  "titulo": "Turma",
  "caminho": "/turmas",
  "editar": true,
  "campos": [
   {
    "nome": "escolaId",
    "rotulo": "Escola",
    "tipo": "ref",
    "ref": "/escolas"
   },
   {
    "nome": "planoCursoId",
    "rotulo": "Plano curso",
    "tipo": "ref",
    "ref": "/planos-curso"
   },
   {
    "nome": "coordenadorId",
    "rotulo": "Coordenador",
    "tipo": "ref",
    "ref": "/usuarios"
   },
   {
    "nome": "codigoTurma",
    "rotulo": "Codigo turma",
    "tipo": "text"
   },
   {
    "nome": "ano",
    "rotulo": "Ano",
    "tipo": "number"
   },
   {
    "nome": "semestre",
    "rotulo": "Semestre",
    "tipo": "number"
   },
   {
    "nome": "dataInicio",
    "rotulo": "Data inicio",
    "tipo": "date"
   },
   {
    "nome": "dataFim",
    "rotulo": "Data fim",
    "tipo": "date"
   },
   {
    "nome": "ativo",
    "rotulo": "Ativo",
    "tipo": "checkbox"
   }
  ]
 },
 {
  "id": "matriculas",
  "titulo": "Turma aluno",
  "caminho": "/matriculas",
  "editar": false,
  "campos": [
   {
    "nome": "turmaId",
    "rotulo": "Turma",
    "tipo": "ref",
    "ref": "/turmas"
   },
   {
    "nome": "alunoId",
    "rotulo": "Aluno",
    "tipo": "ref",
    "ref": "/alunos"
   },
   {
    "nome": "dataMatricula",
    "rotulo": "Data matricula",
    "tipo": "date"
   },
   {
    "nome": "status",
    "rotulo": "Status",
    "tipo": "select",
    "opcoes": [
     "MATRICULADO",
     "CURSANDO",
     "CONCLUIDO",
     "TRANCADO",
     "DESISTENTE",
     "TRANSFERIDO",
     "REPROVADO"
    ]
   }
  ]
 },
 {
  "id": "docentes-ucs",
  "titulo": "Turma docente uc",
  "caminho": "/docentes-ucs",
  "editar": false,
  "campos": [
   {
    "nome": "turmaId",
    "rotulo": "Turma",
    "tipo": "ref",
    "ref": "/turmas"
   },
   {
    "nome": "unidadeCurricularId",
    "rotulo": "Unidade curricular",
    "tipo": "ref",
    "ref": "/unidades-curriculares"
   },
   {
    "nome": "instrutorId",
    "rotulo": "Instrutor",
    "tipo": "ref",
    "ref": "/usuarios"
   }
  ]
 },
 {
  "id": "unidades-curriculares",
  "titulo": "Unidade curricular",
  "caminho": "/unidades-curriculares",
  "editar": true,
  "campos": [
   {
    "nome": "moduloId",
    "rotulo": "Modulo",
    "tipo": "ref",
    "ref": "/modulos"
   },
   {
    "nome": "nome",
    "rotulo": "Nome",
    "tipo": "text"
   },
   {
    "nome": "cargaHoraria",
    "rotulo": "Carga horaria",
    "tipo": "number"
   },
   {
    "nome": "objetivoGeral",
    "rotulo": "Objetivo geral",
    "tipo": "text"
   },
   {
    "nome": "ordem",
    "rotulo": "Ordem",
    "tipo": "number"
   }
  ]
 },
 {
  "id": "usuarios",
  "titulo": "Usuario",
  "caminho": "/usuarios",
  "editar": true,
  "campos": [
   {
    "nome": "nome",
    "rotulo": "Nome",
    "tipo": "text"
   },
   {
    "nome": "email",
    "rotulo": "Email",
    "tipo": "text"
   },
   {
    "nome": "senha",
    "rotulo": "Senha",
    "tipo": "password"
   },
   {
    "nome": "perfilId",
    "rotulo": "Perfil",
    "tipo": "ref",
    "ref": "/perfis"
   },
   {
    "nome": "ativo",
    "rotulo": "Ativo",
    "tipo": "checkbox"
   }
  ]
 }
];
