package come.glasses.serviceImpl;

import come.glasses.dao.mapper.MemberMapper;
import come.glasses.dao.mapper.StockMapper;
import come.glasses.entity.StockEntity;
import come.glasses.entity.dto.stock.StockInputDto;
import come.glasses.entity.dto.stock.StockListDto;
import come.glasses.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2020-04-16 09:13
 */
@Service
public class StockServiceImpl implements StockService {
    private final StockMapper stockMapper;

    @Autowired
    public StockServiceImpl(StockMapper stockMapper) {
        this.stockMapper = stockMapper;
    }

    @Override
    public StockListDto findById(Integer id) {
        return stockMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean insetUser(StockEntity stockEntity) {
        return stockMapper.insert(stockEntity) > 0;
    }

    @Override
    public boolean updateUserInput(StockEntity stockEntity) {
        return stockMapper.updateByPrimaryKey(stockEntity) > 0;
    }

    @Override
    public int insetListUser(List<StockEntity> stockEntityList){
        return stockMapper.insertList(stockEntityList);
    }

    @Override
    public boolean deleteUser(Integer id) {
        return stockMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<StockListDto> getList(StockInputDto input) {
        input.setOffset((input.getPage() - 1) * input.getPageSize());
        return stockMapper.selectAll(input);
    }

    @Override
    public Integer count(StockInputDto input) {
        return stockMapper.countOperationLogs(input);
    }

}
