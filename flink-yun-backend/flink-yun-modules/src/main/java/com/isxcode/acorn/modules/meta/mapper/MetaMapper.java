package com.isxcode.acorn.modules.meta.mapper;

import com.isxcode.acorn.api.datasource.pojos.dto.QueryColumnDto;
import com.isxcode.acorn.api.datasource.pojos.dto.QueryTableDto;
import com.isxcode.acorn.api.meta.req.AddMetaWokReq;
import com.isxcode.acorn.api.meta.res.*;
import com.isxcode.acorn.modules.meta.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface MetaMapper {

    PageMetaDatabaseRes metaDatabaseEntityToPageMetaDatabaseRes(MetaDatabaseEntity metaDatabaseEntity);

    PageMetaTableRes metaTableEntityToPageMetaTableRes(MetaTableEntity metaTableEntity);

    @Mapping(target = "cronConfig", ignore = true)
    MetaWorkEntity addMetaWorkToMetaWorkEntity(AddMetaWokReq addMetaWokReq);

    @Mapping(target = "cronConfigStr", source = "cronConfig")
    @Mapping(target = "cronConfig", ignore = true)
    PageMetaWorkRes metaWorkEntityToPageMetaWorkRes(MetaWorkEntity metaWorkEntity);

    MetaTableEntity queryTableDtoToMetaTableEntity(QueryTableDto queryTableDto);

    List<MetaTableEntity> queryTableDtoListToMetaTableEntityList(List<QueryTableDto> queryTableDtos);

    MetaColumnEntity queryColumnDtoToMetaColumnEntity(QueryColumnDto queryColumnDto);

    List<MetaColumnEntity> queryColumnDtoListToMetaColumnEntityList(List<QueryColumnDto> queryColumnDtos);

    PageMetaColumnRes metaColumnEntityToPageMetaColumnRes(MetaColumnEntity metaColumnEntity);

    PageMetaWorkInstanceRes metaInstanceEntityToPageMetaWorkInstanceRes(MetaInstanceEntity metaInstanceEntity);

    @Mapping(target = "collectDateTime", source = "lastModifiedDateTime")
    GetMetaTableInfoRes metaTableEntityToGetMetaTableInfoRes(MetaTableEntity metaTableEntity);

    @Mapping(target = "datasourceId", source = "metaTableInfoEntity.datasourceId")
    @Mapping(target = "tableName", source = "metaTableInfoEntity.tableName")
    @Mapping(target = "tableComment", source = "metaTableEntity.tableComment")
    @Mapping(target = "refreshDateTime", source = "metaTableInfoEntity.lastModifiedDateTime")
    @Mapping(target = "collectDateTime", source = "metaTableEntity.lastModifiedDateTime")
    GetMetaTableInfoRes metaTableInfoEntityAndmetaTableEntityToGetMetaTableInfoRes(
        MetaTableInfoEntity metaTableInfoEntity, MetaTableEntity metaTableEntity);

    QueryColumnDto metaColumnEntityToQueryColumnDto(MetaColumnEntity metaColumnEntity);

    List<QueryColumnDto> metaColumnEntitiesToQueryColumnDtoList(List<MetaColumnEntity> metaColumnEntities);
}