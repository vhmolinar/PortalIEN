package org.iftm.poo.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name="livro" )
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod")
    private Integer codLivro;
    @Column(name="nome",nullable = false)
    private String nome;
    @Column(name="edicao")
    private String edicao;
    @Column(name="nom_img")
    private String nomImagem;
    @Column(name="ano")
    private Integer ano;
    @Column(name="altura")
    private BigDecimal altura;
    @Column(name="largura")
    private BigDecimal largura;
    @Column(name="comprimento")
    private BigDecimal comprimento;
    @Column(name="diametro")
    private BigDecimal diametro;
    @Column(name="peso")
    private BigDecimal peso;
    @OneToMany(mappedBy = "livro", fetch = FetchType.EAGER)
    private List<ItemLivro> itens;
    @ManyToOne
    @JoinColumn(name="cod_categoria")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name="cod_autor")
    private Autor autor;

    public Livro(){
    }

    public Livro(String nome, String edicao, Integer ano, Categoria categoria, Autor autor) {
        this.nome = nome;
        this.edicao = edicao;
        this.ano = ano;
        this.categoria = categoria;
        this.autor = autor;
    }
    
    public int quantidade() {
        return itens.size();
    }
    
    public int quantidadeDisponivel(){
        int qtde = 0;
        for(ItemLivro itemLivro : itens){
            if(itemLivro.getStatusLivro().equals(StatusLivro.Disponivel)){
                qtde += 1;
            }
        }
        return qtde;
    }
        

    public Integer getCodLivro() {
        return codLivro;
    }
    public void setCodLivro(Integer codLivro) {
        this.codLivro = codLivro;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEdicao() {
        return edicao;
    }
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public List<ItemLivro> getItens() {
        return itens;
    }
    public void setItens(List<ItemLivro> itens) {
        this.itens = itens;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getNomImagem() {
		return nomImagem;
	}

	public void setNomImagem(String nomImagem) {
		this.nomImagem = nomImagem;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((altura == null) ? 0 : altura.hashCode());
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result
				+ ((codLivro == null) ? 0 : codLivro.hashCode());
		result = prime * result
				+ ((comprimento == null) ? 0 : comprimento.hashCode());
		result = prime * result
				+ ((diametro == null) ? 0 : diametro.hashCode());
		result = prime * result + ((edicao == null) ? 0 : edicao.hashCode());
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		result = prime * result + ((largura == null) ? 0 : largura.hashCode());
		result = prime * result
				+ ((nomImagem == null) ? 0 : nomImagem.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (altura == null) {
			if (other.altura != null)
				return false;
		} else if (!altura.equals(other.altura))
			return false;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (codLivro == null) {
			if (other.codLivro != null)
				return false;
		} else if (!codLivro.equals(other.codLivro))
			return false;
		if (comprimento == null) {
			if (other.comprimento != null)
				return false;
		} else if (!comprimento.equals(other.comprimento))
			return false;
		if (diametro == null) {
			if (other.diametro != null)
				return false;
		} else if (!diametro.equals(other.diametro))
			return false;
		if (edicao == null) {
			if (other.edicao != null)
				return false;
		} else if (!edicao.equals(other.edicao))
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		if (largura == null) {
			if (other.largura != null)
				return false;
		} else if (!largura.equals(other.largura))
			return false;
		if (nomImagem == null) {
			if (other.nomImagem != null)
				return false;
		} else if (!nomImagem.equals(other.nomImagem))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		return true;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public BigDecimal getLargura() {
		return largura;
	}

	public void setLargura(BigDecimal largura) {
		this.largura = largura;
	}

	public BigDecimal getComprimento() {
		return comprimento;
	}

	public void setComprimento(BigDecimal comprimento) {
		this.comprimento = comprimento;
	}

	public BigDecimal getDiametro() {
		return diametro;
	}

	public void setDiametro(BigDecimal diametro) {
		this.diametro = diametro;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	@Override
    public String toString() {
        return "Livro{" + "codLivro=" + codLivro + ", nome=" + nome + ", edicao=" + edicao + ", ano=" + ano + ", categoria=" + categoria + ", autor=" + autor + '}';
    }
}