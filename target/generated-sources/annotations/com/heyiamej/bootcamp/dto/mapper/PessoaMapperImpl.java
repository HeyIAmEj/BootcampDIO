package com.heyiamej.bootcamp.dto.mapper;

import com.heyiamej.bootcamp.dto.request.BlogDTO;
import com.heyiamej.bootcamp.dto.request.BlogDTO.BlogDTOBuilder;
import com.heyiamej.bootcamp.dto.request.PessoaDTO;
import com.heyiamej.bootcamp.dto.request.PessoaDTO.PessoaDTOBuilder;
import com.heyiamej.bootcamp.entity.Blog;
import com.heyiamej.bootcamp.entity.Blog.BlogBuilder;
import com.heyiamej.bootcamp.entity.Pessoa;
import com.heyiamej.bootcamp.entity.Pessoa.PessoaBuilder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T21:04:03-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class PessoaMapperImpl implements PessoaMapper {

    @Override
    public Pessoa toPessoa(PessoaDTO pessoaDTO) {
        if ( pessoaDTO == null ) {
            return null;
        }

        PessoaBuilder pessoa = Pessoa.builder();

        if ( pessoaDTO.getDataNascimento() != null ) {
            pessoa.dataNascimento( LocalDate.parse( pessoaDTO.getDataNascimento(), DateTimeFormatter.ofPattern( "dd/MM/yyyy" ) ) );
        }
        pessoa.id( pessoaDTO.getId() );
        pessoa.nome( pessoaDTO.getNome() );
        pessoa.sobrenome( pessoaDTO.getSobrenome() );
        pessoa.documento( pessoaDTO.getDocumento() );
        pessoa.blogs( blogDTOListToBlogList( pessoaDTO.getBlogs() ) );

        return pessoa.build();
    }

    @Override
    public PessoaDTO toDTO(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaDTOBuilder pessoaDTO = PessoaDTO.builder();

        pessoaDTO.id( pessoa.getId() );
        pessoaDTO.nome( pessoa.getNome() );
        pessoaDTO.sobrenome( pessoa.getSobrenome() );
        pessoaDTO.documento( pessoa.getDocumento() );
        if ( pessoa.getDataNascimento() != null ) {
            pessoaDTO.dataNascimento( DateTimeFormatter.ISO_LOCAL_DATE.format( pessoa.getDataNascimento() ) );
        }
        pessoaDTO.blogs( blogListToBlogDTOList( pessoa.getBlogs() ) );

        return pessoaDTO.build();
    }

    protected Blog blogDTOToBlog(BlogDTO blogDTO) {
        if ( blogDTO == null ) {
            return null;
        }

        BlogBuilder blog = Blog.builder();

        blog.id( blogDTO.getId() );
        blog.nome( blogDTO.getNome() );
        blog.descricao( blogDTO.getDescricao() );
        if ( blogDTO.getInscritos() != null ) {
            blog.inscritos( blogDTO.getInscritos() );
        }

        return blog.build();
    }

    protected List<Blog> blogDTOListToBlogList(List<BlogDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Blog> list1 = new ArrayList<Blog>( list.size() );
        for ( BlogDTO blogDTO : list ) {
            list1.add( blogDTOToBlog( blogDTO ) );
        }

        return list1;
    }

    protected BlogDTO blogToBlogDTO(Blog blog) {
        if ( blog == null ) {
            return null;
        }

        BlogDTOBuilder blogDTO = BlogDTO.builder();

        blogDTO.id( blog.getId() );
        blogDTO.nome( blog.getNome() );
        blogDTO.descricao( blog.getDescricao() );
        blogDTO.inscritos( blog.getInscritos() );

        return blogDTO.build();
    }

    protected List<BlogDTO> blogListToBlogDTOList(List<Blog> list) {
        if ( list == null ) {
            return null;
        }

        List<BlogDTO> list1 = new ArrayList<BlogDTO>( list.size() );
        for ( Blog blog : list ) {
            list1.add( blogToBlogDTO( blog ) );
        }

        return list1;
    }
}
